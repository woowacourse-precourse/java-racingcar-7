package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Racing {
    private final Map<String, Integer> positions;

    public Map<String, Integer> positions() {
        return positions;
    }

    public Racing(List<String> carNames) {
        positions = new LinkedHashMap<>();
        for (String name : carNames) {
            positions.put(name, 0);
        }
    }

    public void start(int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            race();
            showStatus();
            System.out.println();
        }
    }

    private void race() {
        for (String name : positions.keySet()) {
            if (canMove()) {
                moveForward(name);
            }
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void moveForward(String name) {
        positions.put(name, positions.get(name) + 1);
    }

    private void showStatus() {
        for (Map.Entry<String, Integer> car : positions.entrySet()) {
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
    }
}