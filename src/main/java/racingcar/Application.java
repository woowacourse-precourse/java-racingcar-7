package racingcar;

import racingcar.domain.RaceGame;
import racingcar.utils.InputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getAttemptCount();

        RaceGame raceGame = new RaceGame(carNames, attemptCount);
        raceGame.startRace();
    }
}
