package racingcar.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import racingcar.message.ErrorMessage;
import racingcar.exception.CarNameException;
import racingcar.model.Car;

public class CarsValidator {

    public void validate(Collection<Car> cars) {
        validateEmpty(cars);
        validateDuplicateNames(cars);
    }

    private static void validateEmpty(Collection<Car> cars) {
        Optional.ofNullable(cars)
                .filter(c -> !c.isEmpty())
                .orElseThrow(() -> new CarNameException(ErrorMessage.CAR_NAME_IS_EMPTY.getMessage()));
    }

    private static void validateDuplicateNames(Collection<Car> cars) {
        Set<String> carNames = new HashSet<>();
        cars.stream()
                .map(Car::getName)
                .forEach(name -> validateUniqueName(name, carNames));
    }

    private static void validateUniqueName(String name, Set<String> carNames) {
        Optional.of(name)
                .filter(carNames::add)
                .orElseThrow(() -> new CarNameException(ErrorMessage.CAR_NAME_IS_DUPLICATED.getMessage()));
    }
}
