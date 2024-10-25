package racingcar.validator;

import static racingcar.exception.ErrorMessage.*;

import java.util.List;
import racingcar.domain.Car;
import racingcar.exception.IllegalArgumentException;

public class Validator {

    public static void validateCarNames(List<Car> cars) {
        cars.forEach(car -> {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_TOO_LONG);
            }
        });
    }

    public static int parseInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException(ATTEMPT_COUNT_CANNOT_BE_ZERO);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }
}
