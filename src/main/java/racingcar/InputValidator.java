package racingcar;

import java.util.List;

public class InputValidator {
    private final int CAR_NAME_LENGTH_LIMIT = 5;
    private final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    public void validateCarNames(List<String> carNames) {

    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
