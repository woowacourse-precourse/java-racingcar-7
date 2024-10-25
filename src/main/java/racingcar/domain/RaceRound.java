package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceRound {

    private final Map<String, String> carPositions;

    public RaceRound(List<Car> cars) {
        this.carPositions = cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getResult
                ));
    }

    public Map<String, String> getCarPositions() {
        return carPositions;
    }
}
