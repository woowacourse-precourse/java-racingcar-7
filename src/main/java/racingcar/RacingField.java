package racingcar;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class RacingField {
    private final Map<Car, Integer> carPositions = new LinkedHashMap<>();

    public RacingField(Cars cars) {
        initialize(cars);
    }

    private void initialize(Cars cars) {
        for (Car car : cars.getCars()) {
            carPositions.put(car, 0);
        }
    }

    public void activeRound() {
        carPositions.replaceAll((car, position) -> position + car.move());
    }

    public Map<Car, Integer> getCarPositions() {
        return Collections.unmodifiableMap(carPositions);
    }
}
