package racingcar.validation;

import racingcar.domain.Car;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.exception.ErrorMessage.*;

public class CarValidation {

    private static final Integer MAX_LENGTH = 5;
    private static final Pattern REGEX = Pattern.compile("[!@#$%^&*]");

    public static void carValid(final List<Car> carList, final String carName) {
        checkNullOrEmptyCarNames(carName);
        checkOverLength(carName);
        checkRegex(carName);
        checkSameCarName(carList, carName);
    }

    private static void checkNullOrEmptyCarNames(final String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_FOUND.getMessage());
        }
    }

    private static void checkOverLength(final String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_LENGTH_FOUND.getMessage());
        }
    }

    private static void checkRegex(final String carName) {
        Matcher matcher = REGEX.matcher(carName);
        if (matcher.find()) {
            throw new IllegalArgumentException(REGEX_FOUND.getMessage());
        }
    }

    private static void checkSameCarName(final List<Car> carList, final String carName) {
        for (Car car : carList) {
            if (car.carName.equals(carName)) {
                throw new IllegalArgumentException(SAME_NAME_FOUND.getMessage());
            }
        }
    }


}
