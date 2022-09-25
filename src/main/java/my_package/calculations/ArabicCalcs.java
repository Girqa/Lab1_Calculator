package my_package.calculations;

import my_package.interfaces.Handler;
import my_package.operations.Add;
import my_package.operations.Div;
import my_package.operations.Mul;
import my_package.operations.Sub;

public class ArabicCalcs extends Calculations implements Handler {
    private int num1;
    private int num2;
    private char sign;
    private final String signs = "[-+*/]";
    public ArabicCalcs(String row){
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
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
        }
        throw new IllegalArgumentException("Неверный формат чисел");
    }
}
