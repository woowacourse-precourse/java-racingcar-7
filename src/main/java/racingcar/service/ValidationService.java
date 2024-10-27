package racingcar.service;

import java.util.List;
import racingcar.constant.ErrorMessage;

public class ValidationService {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNamesInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.ENDS_WITH_COMMA.getMessage());
        }
    }

    public static void validateCarNames(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_CAR_NAMES.getMessage());
        }
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_CAR_NAME.getMessage());
        }
        if (carNames.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
        if (carNames.stream().map(String::toLowerCase).distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static int validateAttempts(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPTS.getMessage());
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ATTEMPTS.getMessage());
        }
    }
}