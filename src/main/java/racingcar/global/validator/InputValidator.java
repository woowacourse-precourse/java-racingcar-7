package racingcar.global.validator;

import static racingcar.global.constant.InvalidInputExceptionMessage.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InputValidator {
    public enum ValidationMode {
        CAR_NAME(1, 5, InputValidator::validateCarName),
        CAR_COUNT(1, 100, InputValidator::validateCarCount),
        GAME_ROUND(1, 1000, InputValidator::validateGameRound);

        public int min;
        public int max;
        private final Consumer<String> validator;

        ValidationMode(int min, int max, Consumer<String> validator) {
            this.min = min;
            this.max = max;
            this.validator = validator;
        }
    }

    public static void validate(ValidationMode mode, String input) {
        Map<ValidationMode, Consumer<String>> modeMap = new HashMap<>();

        for (ValidationMode validationMode : ValidationMode.values()) {
            modeMap.put(validationMode, validationMode.validator);
        }

        Consumer<String> validator = modeMap.get(mode);
        validator.accept(input);
    }

    private static void validateCarName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() < ValidationMode.CAR_NAME.min || name.length() > ValidationMode.CAR_NAME.max)
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);

        }
    }

    private static void validateCarCount(String input) {
        String[] names = input.split(",");

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_MESSAGE);
        }
        if (names.length < ValidationMode.CAR_COUNT.min || names.length > ValidationMode.CAR_COUNT.max) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    private static void validateGameRound(String input) {
        try {
            int n = Integer.parseInt(input);
            if (n < ValidationMode.GAME_ROUND.min || n > ValidationMode.GAME_ROUND.max)
                throw new IllegalArgumentException(INVALID_GAME_ROUND_MESSAGE);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_GAME_ROUND_MESSAGE);
        }
    }
}