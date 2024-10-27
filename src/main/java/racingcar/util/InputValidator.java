package racingcar.util;

import racingcar.racing.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInputs(List<Car> cars, int times) {
        validateCarName(cars);
        validateAttemptTimes(times);
    }

    private static void validateCarName(List<Car> cars) {
        Set<String> carNames = new HashSet<>();

        for (Car car : cars) {
            String carName = car.getCarName();

            if (carNames.contains(carName)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR_MESSAGE.getMessage());
            }

            validateCarNameLength(carName);

            carNames.add(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateAttemptTimes(int times) {
        if (times <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }
}
