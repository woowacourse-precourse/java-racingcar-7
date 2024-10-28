package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<String> carNames;
    private final List<Integer> carPositions;

    private RoundResult(List<String> carNames, List<Integer> carPositions) {
        this.carNames = carNames;
        this.carPositions = carPositions;
    }

    public static RoundResult recordRound(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        List<Integer> carPositions = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.currentName());
            carPositions.add(car.currentPosition());
        }
        return new RoundResult(carNames, carPositions);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
