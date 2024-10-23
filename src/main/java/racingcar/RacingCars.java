package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars = new ArrayList<>();

    public void add(RacingCar car) {
        cars.add(car);
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
