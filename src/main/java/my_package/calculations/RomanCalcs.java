package my_package.calculations;

import my_package.interfaces.Handler;
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
        return Add.execute(a, b);
    }

    @Override
    public int subtraction(int a, int b) {
        return Sub.execute(a, b);
    }

    @Override
    public int multiplication(int a, int b) {
        return Mul.execute(a, b);
    }

    @Override
    public int division(int a, int b) {
        return Div.execute(a, b);
    }

    @Override
    public String[] handleNumbers(String row) {
        return row.split(signs);
    }

    @Override
    public char handleSign(String row){
        for(int i=1; i < signs.length()+1; i++) {
            char curSign = signs.charAt(i);
            if (row.indexOf(signs.charAt(i)) != -1) {
                return curSign;
            }
        }
        throw new IllegalArgumentException("Некорректная операция");
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
        throw new IllegalArgumentException("Неверный формат чисел");
    }
}
