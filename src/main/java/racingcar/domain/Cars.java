package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(NumberGenerator.getRandomNumber());
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }
}
