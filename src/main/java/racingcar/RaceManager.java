package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
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

    public List<String> findWinners(Map<String, Integer> cars) {
        int maxMoveDist = 0;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() > maxMoveDist) {
                maxMoveDist = car.getValue();
                winners.clear();
                winners.add(car.getKey());
            }
            else if (car.getValue() == maxMoveDist) {
                winners.add(car.getKey());
            }
        }

        return winners;
    }

    private boolean isMovable() {
        int numRandom = Randoms.pickNumberInRange(0, 9);
        return numRandom >= 4;
    }
}
