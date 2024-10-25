package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    public CarManager(List<String> carNames) {
        for (String name: carNames)
            cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }
}
