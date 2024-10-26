package racingcar.validation;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateName(String[] inputNames) {
        for (String inputName : inputNames) {
            if (inputName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
        }
    }
}
