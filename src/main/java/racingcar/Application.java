package racingcar;

import racingcar.io.Output;

public class Application {

    private static final Output output = new Output();

    public static void main(String[] args) {
        output.printInputName();

        output.printExecuteCount();
    }
}
