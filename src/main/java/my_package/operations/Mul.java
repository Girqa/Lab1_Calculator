package my_package.operations;

import my_package.interfaces.Operation;

public class Mul implements Operation {
    public static int execute(int a, int b) {
        int result = a * b;
        return result;
    }
}
