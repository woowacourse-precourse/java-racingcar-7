package racingcar.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WinnerCalculator {
    public static int findMaxDistance(List<Car> cars){
        return Collections.max(cars, Comparator.comparingInt(car -> car.getDistance().getDistanceValue()))
                .getDistance().getDistanceValue();
    }
}
