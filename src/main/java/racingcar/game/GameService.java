package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameService {
    void moveEachCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    List<String> getWinnerByRanks(List<Car> cars) {
        HashMap<Integer, List<String>> ranks = new HashMap<>();
        int maxMoveCount = 0;

        for (Car car : cars) {
            int carCurrentMoveCount = car.getCurrentMoveCount();
            maxMoveCount = Math.max(maxMoveCount, carCurrentMoveCount);

            putCarNameInRanks(car, carCurrentMoveCount, ranks);
        }

        return ranks.get(maxMoveCount);
    }

    private boolean checkIsCurrentMoveCountAlreadyExistInRanks(int carCurrentMoveCount, HashMap<Integer, List<String>> ranks) {
        return ranks.containsKey(carCurrentMoveCount);
    }

    private void putCarNameInRanks(Car car, int carCurrentMoveCount, HashMap<Integer, List<String>> ranks) {
        if(!checkIsCurrentMoveCountAlreadyExistInRanks(carCurrentMoveCount, ranks)) {
            ranks.put(carCurrentMoveCount, new ArrayList<>());
        }

        ranks.get(carCurrentMoveCount).add(car.getName());
    }
}
