package racingcar.validator;

import java.util.List;

public class Validator {

    private Validator() {
    }

    public static void validateCarNames(List<String> carNames) {
        carNames.forEach(name -> {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 다섯 글자 이하로 입력하세요.");
            }
        });
    }
    public static void validateAttemptCount(String attemptCountInput) {
        try {
            int attemptCount = Integer.parseInt(attemptCountInput);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 양수로 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수로 입력해야 합니다.");
        }
    }
}
