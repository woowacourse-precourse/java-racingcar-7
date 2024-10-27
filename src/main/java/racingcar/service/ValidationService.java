package racingcar.service;

import java.util.List;
import racingcar.constant.ErrorMessage;

public class ValidationService {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_COUNT = 2;

    public static void validateCarNamesInputFormat(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.UNEXPECTED_COMMA.getMessage());
        }
        if (input.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_CAR_NAME.getMessage());
        }
    }

    public static void validateCarNames(List<String> carNames) {
        if (carNames.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_CAR_NAMES.getMessage());
        }
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.MISSING_CAR_NAME.getMessage());
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
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
