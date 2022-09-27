package my_package.calculations;

import my_package.interfaces.Handler;
import my_package.interfaces.Operation;
import my_package.operations.Add;
import my_package.operations.Div;
import my_package.operations.Mul;
import my_package.operations.Sub;

public class RomanCalcs extends Calculations implements Handler {
    private int num1;
    private int num2;
    private char sign;
    private final String signs = "[-+*/]";
    public RomanCalcs(String row){
        String[] numbers = handleNumbers(row);
        sign = handleSign(row);
        num1 = translateStrNumToInt(numbers[0]);
        num2 = translateStrNumToInt(numbers[1]);
    }

    @Override
    public int calculate(){
        int result = switch (sign){
            case '+' -> addition(num1, num2);
            case '-' -> subtraction(num1, num2);
            case '*' -> multiplication(num1, num2);
            case '/' -> division(num1, num2);
            default -> '0';
        };
        if(result != '0'){
            return result;
        }
        throw new IllegalArgumentException("Некорректная операция");
    }

    @Override
    public int addition(int a, int b) {
        Operation add = new Add();
        return add.execute(a, b);
    }

    @Override
    public int subtraction(int a, int b) {
        Operation sub = new Sub();
        return sub.execute(a, b);
    }

    @Override
    public int multiplication(int a, int b) {
        Operation mul = new Mul();
        return mul.execute(a, b);
    }

    @Override
    public int division(int a, int b) {
        Operation div = new Div();
        return div.execute(a, b);
    }

    @Override
    public String[] handleNumbers(String row) {
        String[] nums = row.split(signs);
        for (int i=0; i<nums.length; i++){
            nums[i] = nums[i].replace(" ", "");
        }
        return nums;
    }

    @Override
    public char handleSign(String row){
        for(int i=1; i < signs.length()+1; i++) {
            char curSign = signs.charAt(i);
            if (row.indexOf(signs.charAt(i)) != -1) {
                return curSign;
            }
        }
        throw new IllegalArgumentException("Знак операции не найден.");
    }

    @Override
    public int translateStrNumToInt(String numStr) {
        switch (numStr){
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        throw new IllegalArgumentException("Число не найдено. Проверьте формат входных чисел.");
    }

    public String intToRoman(int num) {
        String result = "";

        String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < symbols.length && num > 0; i++) {
            while (num >= nums[i]) {
                result += symbols[i];
                num -= nums[i];
            }
        }
        return result;
    }
}
