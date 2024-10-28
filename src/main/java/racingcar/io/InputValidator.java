package racingcar.io;

import java.util.List;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR = "빈 값은 허용하지 않습니다.";
    private static final String INVALID_COUNT_ERROR = "횟수는 0보다 커야 합니다.";

    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_NAME_ERROR = "자동차 이름은 비어 있을 수 없습니다.";
    private static final String NAME_TOO_LONG_ERROR = "자동차 이름은 최대 " + MAX_NAME_LENGTH + "자까지 가능합니다.";

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) { // 공백 문자열도 허용하지 않음
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    public void validateName(List<String> carNames) {
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_ERROR);
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_TOO_LONG_ERROR);
            }
        }
    }

    public void validateCount(int count) {
        if (count > 5) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }
    }

}