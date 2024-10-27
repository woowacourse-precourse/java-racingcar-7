package racingcar.validation;

import static racingcar.constants.GameConstants.*;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateName(String[] inputNames) {
        for (String inputName : inputNames) {
            if (inputName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }
}
