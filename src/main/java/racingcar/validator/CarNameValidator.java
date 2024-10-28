package racingcar.validator;

import racingcar.enums.Constraints;
import racingcar.enums.Exceptions;
import racingcar.enums.StringPattern;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    public CarNameValidator() {
    }

    public void validateCarNames(String input) {
        validateNotBlank(input);
        validateNoSpace(input);
        validateDelimiter(input);
        validateEnd(input);
        String[] carNames = input.split(",");
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            validateEmptyName(carName);
            validateCarNameLength(carName);
            nameSet.add(carName);
        }
        validateDuplication(nameSet.size(), carNames.length);
    }

    void validateCarNameLength(String input) {
        if (input.length() > Constraints.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(Exceptions.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    void validateEnd(String input) {
        if (input.endsWith(StringPattern.CAR_NAME_SEPARATOR.getValue())) {
            throw new IllegalArgumentException(Exceptions.INVALID_END_WITH_COMMA.getMessage());
        }
    }

    void validateDelimiter(String input) {
        String regex = "^[^,]*$";
        if (input.matches(regex)) {
            throw new IllegalArgumentException(Exceptions.INVALID_NAME_DELIMITER_FORMAT.getMessage());
        }
    }

    void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_EMPTY.getMessage());
        }
    }

    void validateNoSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(Exceptions.INVALID_INPUT_WHITESPACE.getMessage());
        }
    }

    void validateDuplication(int carSetSize, int carArrayLength) {
        if (carSetSize != carArrayLength) {
            throw new IllegalArgumentException(Exceptions.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    void validateEmptyName(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Exceptions.EMPTY_CAR_NAME.getMessage());
        }
    }
}
