package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                      .map(Car::from)
                      .toList()
        );
    }

    public int getMaxAdvanceMarkerCount() {
        return cars.stream()
                   .map(Car::getAdvanceMarkerCount)
                   .max(Long::compare)
                   .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
