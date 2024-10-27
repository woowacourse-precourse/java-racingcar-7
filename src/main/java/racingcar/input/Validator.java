package racingcar.input;

import racingcar.util.StringSplitter;

public class Validator {

    public void validateInput(UserInput userInput) {
        validateCarNames(userInput.carNames());
        validateAttemptCount(userInput.attemptCount());
    }

    private void validateCarNames(String carNamesInput) {
        if (carNamesInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상 입력해야 합니다.");
        }

        if (carNamesInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다");
        }

        for (String carName : StringSplitter.splitByComma(carNamesInput)) {
            if (carName.length() >= 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5글자 이하로 입력해야 합니다");
            }
        }
    }

    private void validateAttemptCount(String attemptCountInput) {
        try {
            int attempts = Integer.parseInt(attemptCountInput);
            if (attempts < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

}