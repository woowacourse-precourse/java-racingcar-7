package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNames(carNames);

        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void foward() {
        for (Car car : cars) {
            car.foward();
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
