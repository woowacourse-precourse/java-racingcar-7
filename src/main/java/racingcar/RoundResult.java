package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<String> carNames;
    private final List<Integer> carPositions;

    public RoundResult(List<Car> cars) {
        this.carNames = new ArrayList<>();
        this.carPositions = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.currentName());
            carPositions.add(car.currentPosition());
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
