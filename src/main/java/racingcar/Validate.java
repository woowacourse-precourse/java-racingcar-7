package racingcar;

import java.util.ArrayList;

public class Validate {

    static class InvalidNameLength extends IllegalArgumentException {
        private static final String DEFAULT_MESSAGE = "이름은 공백이 아닌 5자 이하의 문자열이어야 합니다.";

        InvalidNameLength() {
            super(DEFAULT_MESSAGE);
        }

    }

    static class DuplicateNameDetected extends IllegalArgumentException {
        private static final String DEFAULT_MESSAGE = "이름은 중복되지 않아야 합니다.";

        DuplicateNameDetected() {
            super(DEFAULT_MESSAGE);
        }
    }

    static class InvalidRange extends IllegalArgumentException {
        private static final String DEFAULT_MESSAGE = "횟수는 음이 아닌 정수여야 합니다.";

        InvalidRange() {
            super(DEFAULT_MESSAGE);
        }
    }

    static boolean validNameLength(String name) {
        String trimedName = name.trim();
        int nameLength = trimedName.length();
        return nameLength >= 1 && nameLength <= 5;
    }

    static boolean checkName(String name) {
        String trimedName = name.trim();
        if (!validNameLength(trimedName)) {
            throw new InvalidNameLength();
        }
        return true;
    }

    static boolean validNumber(int number) {
        return number >= 0 && number < Integer.MAX_VALUE;
    }
}