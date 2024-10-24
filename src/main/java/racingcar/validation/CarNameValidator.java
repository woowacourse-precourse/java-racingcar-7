package racingcar.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;

public class CarNameValidator {

    public static void validate(String input) {
        validateNull(input);
        validateSeparatorWithoutComma(input);
        validateStartWithComma(input);
        validateEndWithComma(input);
    }

    private static void validateSeparatorWithoutComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    private static void validateStartWithComma(String input) {
        if (Pattern.compile("^,").matcher(input).find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_FRONT_COMMA.getMessage());
        }
    }

    private static void validateEndWithComma(String input) {
        if (Pattern.compile(",$").matcher(input).find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BACK_COMMA.getMessage());
        }
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NULL.getMessage());
        }
    }

    public static void validateCar(String input) {
        String[] cars = input.split(",");
        Set<String> carNames = new HashSet<>();
        for (String car : cars) {
            validateCarNameLength(car);
            validateCarNameDuplication(carNames, car);
            validateCarNameEmpty(car);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ONE_TO_FIVE.getMessage());
        }
    }

    private static void validateCarNameDuplication(Set<String> carNames, String car) {
        if (!carNames.add(car.trim())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION.getMessage());
        }
    }

    private static void validateCarNameEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }
}
