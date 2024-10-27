package racingcar.validation;


import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAMES_ONLY_COMMA;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_DUPLICATED;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_MUST_UNDER_LENGTH_FIVE;
import static racingcar.service.exception.CarNamesExceptionMessage.INVALID_CAR_NAMES_OR_SEPARATOR;
import static racingcar.service.exception.CarNamesExceptionMessage.NO_INPUT;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.service.exception.CarNamesException;

public class CarNamesValidator {

    private static final String KOR_ENG_DIGIT_COMMA_REGEX = ".*[^가-힣a-zA-Z0-9,].*";
    private static final String ONLY_COMMA_REGEX = "^,+$";
    private static final String CAR_NAMES_SEPARATOR = ",";


    public static String validateCarNames(String carNames) {
        validateCarNamesBlank(carNames);
        validateCarNamez(carNames);
        validateCarNamesOnlyComma(carNames);
        validateCarNameUnderLengthFive(carNames);
        validateCarNamesDuplicated(carNames);
        return carNames;
    }

    private static void validateCarNamesBlank(String carNames) {
        if (carNames.isBlank() || carNames == null) {
            throw new CarNamesException(NO_INPUT);
        }
    }

    private static void validateCarNamez(String carNames) {
        if (carNames.matches(KOR_ENG_DIGIT_COMMA_REGEX)) {
            throw new CarNamesException(INVALID_CAR_NAMES_OR_SEPARATOR);
        }
    }

    private static void validateCarNamesOnlyComma(String carNames) {
        if (carNames.matches(ONLY_COMMA_REGEX)) {
            throw new CarNamesException(CAR_NAMES_ONLY_COMMA);
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
                throw new CarNamesException(CAR_NAME_DUPLICATED);
            }
        });
    }
}
