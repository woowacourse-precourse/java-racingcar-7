package racingcar.model;

import java.util.List;

public class Cars {

    public static final int START_POSITION = 0;
    private List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
            .map(carName -> new Car(carName, START_POSITION))
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
