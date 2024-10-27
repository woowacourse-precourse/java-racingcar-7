package racingcar.global.validator;

import racingcar.global.constant.InvalidInputExceptionMessage;
import java.util.function.Consumer;

public class InputValidator {
    public enum ValidationMode {
        CAR_NAME(2, 5, InputValidator::validateCarName),
        CAR_COUNT(2, 10, InputValidator::validateCarCount),
        GAME_ROUND(1, 1000, InputValidator::validateGameRound);

        private final int min;
        private final int max;
        private final Consumer<String> validator;

        ValidationMode(int min, int max, Consumer<String> validator) {
            this.min = min;
            this.max = max;
            this.validator = validator;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }

        public void validate(String input) {
            validator.accept(input);
        }
    }

    public static void validate(ValidationMode mode, String input) {
        mode.validate(input);
    }

    private static void validateCarName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() < ValidationMode.CAR_NAME.getMin() || name.length() > ValidationMode.CAR_NAME.getMax())
                throw new IllegalArgumentException(
                        InvalidInputExceptionMessage.carNameLength(
                                ValidationMode.CAR_NAME.getMin(), ValidationMode.CAR_NAME.getMax()));
        }
    }

    private static void validateCarCount(String input) {
        String[] names = input.split(",");
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    InvalidInputExceptionMessage.emptyCarName());
        }
        if (names.length < ValidationMode.CAR_COUNT.min || names.length > ValidationMode.CAR_COUNT.max) {
            throw new IllegalArgumentException(
                    InvalidInputExceptionMessage.carCount(
                            ValidationMode.CAR_COUNT.min, ValidationMode.CAR_COUNT.max));
        }
    }

    private static void validateGameRound(String input) {
        try {
            int n = Integer.parseInt(input);
            if (n < 0) {
                throw new IllegalArgumentException(
                        InvalidInputExceptionMessage.gameRoundNotNaturalNumber());
            }
            if (n < ValidationMode.GAME_ROUND.min || n > ValidationMode.GAME_ROUND.max) {
                throw new IllegalArgumentException(
                        InvalidInputExceptionMessage.gameRoundRange(
                                ValidationMode.GAME_ROUND.min, ValidationMode.GAME_ROUND.max));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    InvalidInputExceptionMessage.gameRoundNotNaturalNumber());
        }
    }
}