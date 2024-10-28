package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputCarNameHandler inputCarNameHandler = new InputCarNameHandler();
        List<String> carNames = inputCarNameHandler.getCarNames();

        InputAttemptHandler inputAttemptHandler = new InputAttemptHandler();
        int attemptCount = inputAttemptHandler.getAttemptCount();
        System.out.println();

        CarRace carRace = new CarRace();
        carRace.initializeCarPositions(carNames);
        carRace.attemptRace(attemptCount);

        WinnerAnnouncer winnerAnnouncer = new WinnerAnnouncer();
        winnerAnnouncer.announceWinners(carRace.getCarPositions());
    }
}