package racingcar;

import java.util.LinkedHashMap;

public class RaceController {
    private final int attemptCount;
    private final LinkedHashMap<Car, Integer> cars;

    public RaceController(LinkedHashMap<Car, Integer> cars, int attemptCount) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }
}
