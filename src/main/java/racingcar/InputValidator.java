package racingcar;

import java.util.List;

public class InputValidator {

    public void validateCarNames(List<String> carNames, String input) {
        carNames.forEach(name -> {
            validateEmpty(name, "자동차 이름은 비어있을 수 없습니다.");
            validateCarNameLength(name);
            validateNoSpaceInCarName(name);
        });
        validateCarCount(carNames);
        validateEndWithComma(input);
    }

    public void validateEmpty(String input, String message) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validateNoSpaceInCarName(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에는 공백을 포함할 수 없습니다.");
        }
    }

    private void validateCarCount(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("2대 이상의 차량을 다시 입력해 주세요.");
        }
    }

    private void validateEndWithComma(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 끝날 수 없습니다.");
        }
    }

    public void validateTryCount(String input) {
        validateEmpty(input, "시도 횟수는 비어있을 수 없습니다.");
        validateTryCountType(input);
    }

    private void validateTryCountType(String input) {
        try {
            int count = Integer.parseInt(input);
            validatePositiveTryCount(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    private void validatePositiveTryCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}