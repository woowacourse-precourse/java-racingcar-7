package racingcar.domain;

import static racingcar.validation.ErrorMessage.NOT_PERMIT_SAME_CAR;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException(NOT_PERMIT_SAME_CAR.getMessage());
        }
    }

}
