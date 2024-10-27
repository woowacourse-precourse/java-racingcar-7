package racingcar;

import racingcar.Input.ConsoleInputHandler;
import racingcar.Input.InputHandler;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();

        Racing racing = new Racing(inputHandler);

        racing.start();
    }
}
