package racingcar.view;

public class InputValidator {
    public static void validateUserInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }
    }
}
