package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<String> carNames;
    private final List<Integer> carPositions;

    public Race(List<String> carNames) {
        this.carNames = carNames;
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carPositions.add(0);
        }
    }

    public void moveCars() {
        for (int i = 0; i < carNames.size(); i++) {
            int randomValue = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carPositions.set(i, carPositions.get(i) + 1);
            }
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
