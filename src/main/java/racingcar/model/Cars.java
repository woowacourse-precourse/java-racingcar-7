package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void saveCar(final String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> calculateFarthestCars() {
        List<Car> farthestCars = new ArrayList<>();
        long maxPosition = Collections.max(cars).getPosition();
        for (Car car : cars) {
            long carPosition = car.getPosition();
            if (carPosition == maxPosition) {
                farthestCars.add(car);
            }
        }
        return farthestCars;
    }
}
