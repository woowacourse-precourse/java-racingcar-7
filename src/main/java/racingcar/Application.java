package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        System.out.println("========== 자동차 경주 게임 ==========");
        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getAttempCount();
        System.out.println();

        CarRace carRace = new CarRace();
        carRace.initializeCarPositions(carNames);
        carRace.attemptRace(attemptCount);
    }
}
