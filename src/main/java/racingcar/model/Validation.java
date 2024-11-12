package racingcar.model;

import java.util.List;

import static racingcar.constant.ExceptionMessage.*;

public class Validation {
    public void validCarNameDelimiter(String rawCarNames) {
        if (!rawCarNames.matches("^[a-zA-Z0-9, ]+$")) {
            throw new IllegalArgumentException(CAR_NAME_DELIMITER_ERROR.getMessage());
        }
    }

    public void checkEmptyName(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name == null || name.trim().isEmpty())) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    public void validateCarNameLength(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

    public void checkEmptyInput(String rawCarNames) {
        if (rawCarNames.trim().isEmpty() || rawCarNames.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_NO_INPUT.getMessage());
        }
    }

    public void validateAttemptCount(String attemptCount) {
        int attempt;
        try {
            attempt = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
        if (attempt <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE.getMessage());
        }
    }

    public void validateOutputFormat(String output, List<String> winners) {
        String expectedOutput = "최종 우승자 : " + String.join(", ", winners);
        if (!output.equals(expectedOutput)) {
            throw new IllegalArgumentException(WRONG_FORMAT.getMessage());
        }
    }

}
