package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRacer {

    private final List<String> carNames;
    private final Map<String, Integer> carPositions;

    public CarRacer(List<String> carNames) {
        this.carNames = carNames;
        this.carPositions = new HashMap<>();
        initializeCarPositions();
    }

    private void initializeCarPositions() {
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }
    }

    public void startRace(int moveCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            racing();
            racingResultPrint();
        }
    }

    private void racingResultPrint() {
        for (String carName : carNames) {
            int position = carPositions.get(carName);
            System.out.println(carName + " : " + "-".repeat(position));
        }
        System.out.println();
    }

    private void racing() {
        for (String carName : carNames) {
            if (moveOrStop()) {
                carPositions.put(carName, carPositions.get(carName) + 1);
            }
        }
    }

    private static boolean moveOrStop() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinnerCarNames(maxPosition);
    }

    private List<String> findWinnerCarNames(int maxPosition) {
        List<String> winnersList = new ArrayList<>();
        for (String carName : carNames) {
            if (carPositions.get(carName) == maxPosition) {
                winnersList.add(carName);
            }
        }
        return winnersList;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (int position : carPositions.values()) {
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    public Map<String, Integer> getCarPositions() {
        return carPositions;
    }
}