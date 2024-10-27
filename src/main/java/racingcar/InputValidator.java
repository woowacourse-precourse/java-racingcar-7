package racingcar;

public class InputValidator {
    final String inputText;

    public InputValidator(String inputText) {
        this.inputText = inputText;
    }

    public void carNameValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하세요.");
        }
    }

    public void attemptCountValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException("시도 횟수를 입력하세요.");
        }
    }

    private boolean isBlankInput() {
        return inputText.isBlank();
    }
}