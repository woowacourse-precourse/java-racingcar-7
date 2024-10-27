package racingcar.validation;


import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_DUPLICATE;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_MUST_ENG_KOR_DIGIT;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_MUST_UNDER_LENGTH_FIVE;
import static racingcar.service.exception.CarNamesExceptionMessage.INVALID_SEPARATOR;
import static racingcar.service.exception.CarNamesExceptionMessage.NO_INPUT;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.service.exception.CarNamesException;

public class CarNamesValidator {

    private static final String SPECIAL_CHARACTER_EXCEPT_COMMA = ".*[^가-힣a-zA-Z0-9,].*";
    private static final String CAR_NAME_REGEX = "^[a-zA-Z0-9가-힣]+$";
    private static final String CAR_NAMES_SEPARATOR = ",";


    public static String validateCarNames(String carNames) {
        validateCarNamesBlank(carNames);
        validateSeparator(carNames);
        validateCarNameEngKorDigit(carNames);
        validateCarNameUnderLengthFive(carNames);
        validateCarNamesDuplicated(carNames);
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

    private static void validateCarNameUnderLengthFive(String carNames) {
        for (String carName : carNames.split(CAR_NAMES_SEPARATOR)) {
            if (carName.length() > 5) {
                throw new CarNamesException(CAR_NAME_MUST_UNDER_LENGTH_FIVE);
            }
        }
    }

    private static void validateCarNamesDuplicated(String carNames) {
        Map<String, Long> nameCountMap = Arrays.stream(carNames.split(CAR_NAMES_SEPARATOR))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        nameCountMap.forEach((name, count) -> {
            if (count > 1) {
                throw new CarNamesException(CAR_NAME_DUPLICATE);
            }
        });
    }
}
