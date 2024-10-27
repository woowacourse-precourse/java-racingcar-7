package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputCarNameHandler inputCarNameHandler = new InputCarNameHandler();
        try {
            inputCarNameHandler.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        InputAttemptHandler inputAttemptHandler = new InputAttemptHandler();

        System.out.println("========== 자동차 경주 게임 ==========");
        List<String> carNames = inputCarNameHandler.getCarNames();
        int attemptCount = inputAttemptHandler.getAttempCount();
        System.out.println();

        CarRace carRace = new CarRace();
        carRace.initializeCarPositions(carNames);
        carRace.attemptRace(attemptCount);

        WinnerAnnouncer winnerAnnouncer = new WinnerAnnouncer();
        winnerAnnouncer.announceWinners(carRace.getCarPositions());
    }
}
