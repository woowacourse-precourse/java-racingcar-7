package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> moveCars() {
        List<Car> movingCars = new ArrayList<>();

        for (Car car : this.cars) {
            movingCars.add(car.move());
        }

        return movingCars;
    }
}
