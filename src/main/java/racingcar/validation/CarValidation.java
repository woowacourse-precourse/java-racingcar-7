package racingcar.validation;

import racingcar.domain.Car;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.exception.ErrorMessage.*;

public class CarValidation {

    private static void checkNullOrEmpty(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_FOUND.getMessage());
        }
    }


}
