package racingcar.service;

import java.util.List;
import racingcar.constant.ErrorMessage;

public class ValidationService {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (carNames.size() < 2) {
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