package racingcar;

import racingcar.Input.ConsoleInputHandler;
import racingcar.Input.InputHandler;
import racingcar.Output.ConsoleOutputHandler;
import racingcar.Output.OutputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Racing racing = new Racing(inputHandler, outputHandler);

        racing.start();
    }
}
