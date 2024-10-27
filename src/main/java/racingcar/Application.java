package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        System.out.println("========== 자동차 경주 게임 ==========");
        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getAttempCount();

        CarRace carRace = new CarRace();
        Map<String, Integer> carPositions = carRace.initializeCarPositions(carNames);
        for (int i = 0; i < attemptCount; i++) {
            System.out.println(i + 1 + "번째 시도");
            carRace.moveCars(carPositions);
        }
    }
}
