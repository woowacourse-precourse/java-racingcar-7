package racingcar;

import racingcar.view.ConsoleInput;
import racingcar.view.ConsoleOutput;

import static racingcar.common.constant.OutputConstant.*;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        consoleOutput.print(INPUT_CAR_NAME);
        String carName = consoleInput.inputString();

        consoleOutput.print(INPUT_TRY_COUNT);
        Integer carTryCount = consoleInput.inputNumber();

    }
}
