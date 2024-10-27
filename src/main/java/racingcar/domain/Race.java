package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Race {

    private final Map<String, Integer> carPositions;
    private final int forwardCount;

    private Race(Car car, int forwardCount) {
        this.carPositions = new HashMap<>();
        this.forwardCount = forwardCount;
        setInitialPositions(car);
    }

    public static Race of(Car car, int forwardCount) {
        return new Race(car, forwardCount);
    }

    private void setInitialPositions(Car car) {
        car.getCars()
                .forEach(carName -> carPositions.put(carName, 0));
    }

}