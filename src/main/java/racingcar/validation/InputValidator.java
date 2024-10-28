package racingcar.validation;

import racingcar.constant.AppConstants;
import racingcar.constant.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void checkDelimiter(String input) {
        if (input.contains(AppConstants.DELIMITER + AppConstants.DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_CANNOT_BE_CONSECUTIVE.getMessage());
        }

        if (input.startsWith(AppConstants.DELIMITER) || input.endsWith(AppConstants.DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER_CANNOT_BE_AT_START_OR_END.getMessage());
        }
    }

    public void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMERIC.getMessage());
        }
    }

    public void attemptCount(int attempts) {
        if (attempts > AppConstants.MAX_ATTEMPTS) {
            throw new IllegalArgumentException(ErrorMessage.MAX_ATTEMPTS_EXCEEDED.getMessage());
        }
    }

    public void carNames(List<String> carNames) {
        if (carNames.size() > AppConstants.MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAX_CARS_EXCEEDED.getMessage());
        }

        // 빈 문자열이나 공백 문자열이 있는지 확인
        if (carNames.stream().anyMatch(name -> name.trim().isEmpty())) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CANNOT_BE_EMPTY.getMessage());
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES_NOT_ALLOWED.getMessage());
        }

        carNames.forEach(this::validateCarName);
    }

    public void validateCarName(String name) {
        if (name == null || name.isEmpty() || name.length() > AppConstants.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }
}