package racingcar;

import racingcar.domain.Racing;
import racingcar.io.Input.ConsoleInputHandler;
import racingcar.io.Input.InputHandler;
import racingcar.io.Output.ConsoleOutputHandler;
import racingcar.io.Output.OutputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Racing racing = new Racing(inputHandler, outputHandler);

        racing.start();
    }
}
