package racingcar;

import java.util.List;
import racingcar.controller.CarRacingGame;
import racingcar.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.carNames();
        int moveAttemptCount = inputHandler.moveAttemptCount();
        CarRacingGame racingGame = new CarRacingGame(carNames, moveAttemptCount);
        racingGame.start();
    }
}