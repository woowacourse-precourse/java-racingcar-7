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
            String trimmedName = name.trim();
            validateCarName(trimmedName);
            if (!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
        }
    }

    private void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        // 1자 이상 조건 추가
        if (name.length() < 1) {
            throw new IllegalArgumentException("이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        if (!name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("자동차 이름은 영문자와 숫자만 가능합니다.");
        }
    }

    public void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void validateInputFormat(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        if (!input.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$")) {
            throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
        }
        // 공백으로만 구성된 이름 체크 추가 필요
        String[] parts = input.split(",");
        for (String part : parts) {
            if (part.trim().isEmpty()) {
                throw new IllegalArgumentException("이름이 공백인 자동차가 있습니다.");
            }
        }
    }

}
