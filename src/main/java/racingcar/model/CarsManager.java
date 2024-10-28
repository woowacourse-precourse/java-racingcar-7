package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarsManager {

    private final List<Car> cars = new ArrayList<>();


    public CarsManager(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
