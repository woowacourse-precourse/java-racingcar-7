package racingcar.validation;


import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_MUST_ENG_KOR_DIGIT;
import static racingcar.service.exception.CarNamesExceptionMessage.INVALID_SEPARATOR;
import static racingcar.service.exception.CarNamesExceptionMessage.NO_INPUT;

import racingcar.service.exception.CarNamesException;

public class CarNamesValidator {

    private static final String SPECIAL_CHARACTER_EXCEPT_COMMA = ".*[^가-힣a-zA-Z0-9,].*";
    private static final String CAR_NAME_REGEX = "^[a-zA-Z0-9가-힣]+$";
    private static final String CAR_NAMES_SEPARATOR = ",";


    public static String validateCarNames(String carNames) {
        validateCarNamesBlank(carNames);
        validateSeparator(carNames);
        validateCarNameEngKorDigit(carNames);
        return carNames;
    }

    private static void validateCarNamesBlank(String carNames) {
        if (carNames.isBlank() || carNames == null) {
            throw new CarNamesException(NO_INPUT);
        }
    }

    private static void validateSeparator(String carNames) {
        if (carNames.matches(SPECIAL_CHARACTER_EXCEPT_COMMA)) {
            throw new CarNamesException(INVALID_SEPARATOR);
        }
    }

    private static void validateCarNameEngKorDigit(String carNames) {
        for (String carName : carNames.split(CAR_NAMES_SEPARATOR)) {
            if (!carName.matches(CAR_NAME_REGEX)) {
                throw new CarNamesException(CAR_NAME_MUST_ENG_KOR_DIGIT);
            }
        }
    }
}
