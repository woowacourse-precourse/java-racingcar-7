package racingcar.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public void validateCarNames(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            validateCarName(name.trim());
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
        }
    }

    private void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (!name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("이름은 영문자와 숫자만 가능합니다.");
        }
    }

    public void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
