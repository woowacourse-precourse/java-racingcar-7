package racingcar.model;

import static racingcar.constant.ExceptionMessage.CAR_NAME_DELIMITER_ERROR;
import static racingcar.constant.ExceptionMessage.CAR_NAME_EMPTY;
import static racingcar.constant.ExceptionMessage.CAR_NAME_LENGTH_EXCEEDED;
import static racingcar.constant.ExceptionMessage.CAR_NAME_NO_INPUT;
import static racingcar.constant.ExceptionMessage.NOT_INTEGER;
import static racingcar.constant.ExceptionMessage.NOT_POSITIVE;

import java.util.List;

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
        Integer attempt;
        try {
            attempt = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
        if (attempt <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE.getMessage());
        }
    }

    public boolean isValidOutputFormat(String output, List<String> winners) {
        String expectedOutput = "최종 우승자 : " + String.join(", ", winners);
        return output.equals(expectedOutput);
    }

}
