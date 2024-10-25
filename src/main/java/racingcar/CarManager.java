package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    public void createCars(List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
