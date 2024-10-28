package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputCarNameHandler inputCarNameHandler = new InputCarNameHandler();
        InputAttemptHandler inputAttemptHandler = new InputAttemptHandler();
        CarRace carRace = new CarRace();
        WinnerAnnouncer winnerAnnouncer = new WinnerAnnouncer();

        List<String> carNames = new ArrayList<>();
        int attemptCount = 0;

        try {
            carNames = inputCarNameHandler.getCarNames();
            attemptCount = inputAttemptHandler.getAttemptCount();

            carRace.initializeCarPositions(carNames);
            carRace.attemptRace(attemptCount);

            winnerAnnouncer.announceWinners(carRace.getCarPositions());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}