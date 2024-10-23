package racingcar.exception;

public class InputValidation {

    public void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }

    public void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 포함할 수 없습니다.");
        }
    }

}
