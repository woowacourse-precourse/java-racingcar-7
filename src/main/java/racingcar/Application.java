package racingcar;

import racingcar.controller.GameController;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;

public class Application {
    public static void main(String[] args) {
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

        GameController gameController = new GameController(inputHandler, outputHandler);
        gameController.startGame();
    }
}
