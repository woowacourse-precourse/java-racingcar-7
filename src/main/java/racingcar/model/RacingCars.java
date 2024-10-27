package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars = new ArrayList<>();

    public void add(Car car) {
        racingCars.add(car);
    }
}
