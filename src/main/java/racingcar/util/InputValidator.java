package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_ATTEMPT_COUNT = 100;

    public void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException("공백은 이름에 포함될 수 없습니다.");
        }
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,) 구분자 사용이 틀렸습니다.");
        }
        List<String> names = Arrays.asList(carNames.split(","));
        for (String name : names) {
            validateCarName(name);
        }
        hasDuplications(names);
    }

    public void validateAttemptCount(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        } else if (attemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 100번 이하로 가능합니다.");
        }
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("쉼표(,) 구분자가 연속으로 나올 수 없습니다.");
        }
    }

    private void hasDuplications(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("중복되지 않은 이름을 작성해야 합니다.");
            }
        }
    }
}
