package racingcar.controller;

import java.util.Objects;

public class AttemptCountValidator {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "시도 횟수는 정수로만 입력이 가능합니다.";

    public Integer validate(String inputString) {
        if (!isBlank(inputString)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }

        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    private boolean isBlank(String inputString) {
        return !Objects.isNull(inputString) && !inputString.isBlank();
    }
}
