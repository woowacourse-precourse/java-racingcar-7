package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> racingCars = new ArrayList<>();

    public void addCar(Car car) {
        racingCars.add(car);
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
