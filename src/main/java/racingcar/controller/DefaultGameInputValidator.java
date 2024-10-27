package racingcar.controller;

import static racingcar.controller.ExceptionMessages.Default.CAR_NAME_ENDS_WITH_DELIMITER;
import static racingcar.controller.ExceptionMessages.Default.CAR_NAME_ONLY_DELIMITER;
import static racingcar.controller.ExceptionMessages.Default.EMPTY_CAR_NAME;
import static racingcar.controller.ExceptionMessages.Default.EMPTY_TOTAL_ROUNDS;
import static racingcar.controller.ExceptionMessages.Default.INVALID_CAR_NAME_CHARACTERS;
import static racingcar.controller.ExceptionMessages.Default.TOTAL_ROUNDS_NOT_INTEGER;

public class DefaultGameInputValidator implements GameInputValidator {

    private static DefaultGameInputValidator instance;

    private static final String DELIMITER = ",";
    private static final String KOREAN_RANGE_OF_REGEX = "가-힣";
    private static final String ENGLISH_RANGE_OF_REGEX = "a-zA-Z";
    private static final String NUMBER_RANGE_OF_REGEX = "0-9";
    private static final String WHITESPACE_REGEX = "\\s";

    private DefaultGameInputValidator() {
    }

    public static DefaultGameInputValidator getInstance() {
        if (instance == null) {
            instance = new DefaultGameInputValidator();
        }
        return instance;
    }

    @Override
    public void validateNameOfCars(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }

        if (containsOnlyDelimiter(input)) {
            throw new IllegalArgumentException(CAR_NAME_ONLY_DELIMITER);
        }

        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(CAR_NAME_ENDS_WITH_DELIMITER);
        }

        if (containsInvalidCharactersForNameOfCars(input)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_CHARACTERS);
        }
    }

    @Override
    public void validateTotalRounds(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_TOTAL_ROUNDS);
        }

        if (!isInteger(input)) {
            throw new IllegalArgumentException(TOTAL_ROUNDS_NOT_INTEGER);
        }
    }

    private boolean containsOnlyDelimiter(String input) {
        return input.replace(DELIMITER, "").isBlank();
    }

    private boolean containsInvalidCharactersForNameOfCars(String input) {
        String pattern = "[" + KOREAN_RANGE_OF_REGEX + ENGLISH_RANGE_OF_REGEX + NUMBER_RANGE_OF_REGEX + DELIMITER
                + WHITESPACE_REGEX + "]*";
        return !input.matches(pattern);
    }

    private boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }
}
