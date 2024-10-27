package racingcar.view.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.view.global.exception.CustomException;
import racingcar.view.global.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (hasDuplicateCarNames(cars)) {
            throw CustomException.of(ErrorMessage.DUPLICATE_CAR_NAME_ERROR);
        }
        this.cars = cars;
    }

    private boolean hasDuplicateCarNames(List<Car> cars) {
        Set<String> carUniqueNames = cars.stream().map(Car::getName).collect(Collectors.toSet());
        return carUniqueNames.size() != cars.size();
    }
}
