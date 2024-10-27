package racingcar.validation;

import static racingcar.constants.GameConstants.*;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNameLength(String[] inputNames) {
        for (String inputName : inputNames) {
            if (inputName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    public static void validateNameEmpty(String[] inputNames) {
        if (inputNames.length > 0) {
            String lastName = inputNames[inputNames.length - 1];

            if (lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("이름 입력이 공백일 수 없습니다.");
            }
        }
    }

    public static void validateTime(int inputTime) {
        if (inputTime < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상의 정수여야 합니다.");
        }
    }
}
