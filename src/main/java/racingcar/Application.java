package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;


public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        System.out.println("========== 자동차 경주 게임 ==========");
        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getAttempCount();

        CarRace carRace = new CarRace();
        Map<String, Integer> carPositions = carRace.initializeCarPositions(carNames);
    }
}
