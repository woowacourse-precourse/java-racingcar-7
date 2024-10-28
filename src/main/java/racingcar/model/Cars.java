package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(final List<String> carList) {
        for (String carName : carList) {
            this.cars.add(new Car(carName));
        }
    }
}
