package racingcar.model;

import static racingcar.common.exception.ErrorMessage.CAR_NAME_DUPLICATION_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record Cars(Set<Car> cars) {

    public Cars {
        Objects.requireNonNull(cars);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(Validator.validate(cars));
    }

    private static class Validator {
        private static Set<Car> validate(List<Car> cars) {
            validateNoDuplication(cars);
            return new HashSet<>(cars);
        }

        private static void validateNoDuplication(List<Car> cars) {
            int distinctCount = cars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toSet())
                    .size();

            if (distinctCount != cars.size()) {
                throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR);
            }
        }
    }
}
