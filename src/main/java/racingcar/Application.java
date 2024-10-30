package racingcar;

import racingcar.controller.GameController;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
        RandomGenerator randomGenerator = new RandomNumberGenerator();

        GameController gameController = new GameController(inputHandler, outputHandler, randomGenerator);
        gameController.startGame();
    }
}
