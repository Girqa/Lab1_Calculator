package my_package.operations;

import my_package.interfaces.Operation;

public class Div implements Operation {
    public int execute(int a, int b) {
        return a/b;
    }
}
