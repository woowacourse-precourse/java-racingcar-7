package racingcar.utils;

import java.util.List;

public class InputValidator {

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private void validateNameEmpty(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(Constant.CAR_NAME_EMPTY_ERROR_MESSAGE);
            }
        }
    }
}
