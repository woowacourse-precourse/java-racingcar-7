package racingcar.input;

import racingcar.util.StringSplitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }

        List<String> carNames = StringSplitter.splitByComma(carNamesInput);

        // 중복 이름 검증
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        // 각 이름의 길이 검증
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5글자 이하로 입력해야 합니다.");
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