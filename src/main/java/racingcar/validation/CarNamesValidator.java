package racingcar.validation;

import static racingcar.service.exception.CarNamesExceptionMessage.NO_INPUT;

import racingcar.service.exception.CarNamesException;

public class CarNamesValidator {

    public static String validateCarNames(String carNames) {
        validateCarNamesBlank(carNames);
        return carNames;
    }

    private static void validateCarNamesBlank(String carNames) {
        if (carNames.isBlank() || carNames == null) {
            throw new CarNamesException(NO_INPUT);
        }
    }
}
