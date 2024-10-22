package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameService {
    List<String> getWinnerByRanks(List<Car> cars) {
        HashMap<Integer, List<String>> ranks = new HashMap<>();
        int maxMoveCount = 0;

        for (Car car : cars) {
            int carCurrentMoveCount = car.getCurrentMoveCount();
            maxMoveCount = Math.max(maxMoveCount, carCurrentMoveCount);

            if (!ranks.containsKey(carCurrentMoveCount)) {
                ranks.put(carCurrentMoveCount, new ArrayList<>());
            }

            ranks.get(carCurrentMoveCount).add(car.getName());
        }

        return ranks.get(maxMoveCount);
    }
}
