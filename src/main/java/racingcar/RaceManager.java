package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RaceManager {

    public Map<String, Integer> raceOnce(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (isMovable()) {
                car.setValue(car.getValue() + 1);
            }
        }
        return cars;
    }

    private boolean isMovable() {
        int numRandom = Randoms.pickNumberInRange(0, 9);
        return numRandom >= 4;
    }
}
