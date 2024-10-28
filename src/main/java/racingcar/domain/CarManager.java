package racingcar.domain;

import static racingcar.validation.ErrorMessage.NOT_PERMIT_SAME_CAR;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarManager {

    private final List<Car> cars;

    public CarManager(List<Car> cars) {
        verifyDuplicateCar(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void verifyDuplicateCar(List<Car> cars) {
        Set<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException(NOT_PERMIT_SAME_CAR.getMessage());
        }
    }

}
