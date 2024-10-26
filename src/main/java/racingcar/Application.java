package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class Application {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) {
        output.printInputName();
        String carNames = input.getUserAnswer();
        output.printExecuteCount();
        String executeCount = input.getUserAnswer();
    }
}
