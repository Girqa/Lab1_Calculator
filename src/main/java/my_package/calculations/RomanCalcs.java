package my_package.calculations;

import my_package.interfaces.Handler;

public class RomanCalcs extends Calculations implements Handler {
    public RomanCalcs(String row){
        ;
    }

    @Override
    public int addition(int a, int b) {
        return 0;
    }

    @Override
    public int subtraction(int a, int b) {
        return 0;
    }

    @Override
    public int multiplication(int a, int b) {
        return 0;
    }

    @Override
    public int division(int a, int b) {
        return 0;
    }

    @Override
    public String[] handleNumbers(String row) {
        return new String[0];
    }

    @Override
    public char handleSign(String row) {
        return 0;
    }

    @Override
    public int translateStrNumToInt(String numStr) {
        return 0;
    }
}
