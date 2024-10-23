package racingcar;

public class Validator {

    public void validateInput(UserInput userInput) {
        validateCars(userInput.carNames());
        validateAttemptCount(userInput.attemptCount());
    }

    private void validateCars(String carNamesInput) {
        if (carNamesInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상 입력해야 합니다.");
        }
    }

    private void validateAttemptCount(String attemptCountInput) {
        try {
            int attempts = Integer.parseInt(attemptCountInput);
            if (attempts < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

}