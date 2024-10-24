package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RankService {
    private final HashMap<Integer, List<String>> ranks = new HashMap<>();

    List<String> getWinnerByRanks(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            int carCurrentMoveCount = car.getCurrentMoveCount();
            maxMoveCount = Math.max(maxMoveCount, carCurrentMoveCount);

            putCarNameInRanks(car, carCurrentMoveCount);
        }

        return ranks.get(maxMoveCount);
    }

    private boolean checkIsCurrentMoveCountAlreadyExistInRanks(int carCurrentMoveCount) {
        return ranks.containsKey(carCurrentMoveCount);
    }

    private void putCarNameInRanks(Car car, int carCurrentMoveCount) {
        if (!checkIsCurrentMoveCountAlreadyExistInRanks(carCurrentMoveCount)) {
            ranks.put(carCurrentMoveCount, new ArrayList<>());
        }

        ranks.get(carCurrentMoveCount).add(car.getName());
    }
}
