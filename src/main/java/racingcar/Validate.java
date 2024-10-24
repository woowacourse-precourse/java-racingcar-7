package racingcar;

/**
 * 입력값 검증 및 예외 발생을 담당하는 클래스
 */
class Validate {
    static class InvalidNameLength extends IllegalArgumentException {
        private static final String MESSAGE = "이름은 공백이 아닌 5자 이하의 문자열이어야 합니다.";

        InvalidNameLength() {
            super(MESSAGE);
        }

    }

    static class DuplicateNameDetected extends IllegalArgumentException {
        private static final String MESSAGE = "이름은 중복되지 않아야 합니다.";

        DuplicateNameDetected() {
            super(MESSAGE);
        }
    }

    static class CannotBeNegative extends IllegalArgumentException {
        private static final String MESSAGE = "횟수는 음이 아닌 정수여야 합니다.";

        CannotBeNegative() {
            super(MESSAGE);
        }
    }

    /**
     * 이름이 유효한지(공백이 아니며 5자 이하) 검증
     * @param name 이름 문자열
     * @return 유효한 값이면 true
     */
    static boolean validNameLength(String name) {
        int nameLength = name.length();
        return nameLength >= 1 && nameLength <= 5;
    }

    /**
     * 이름이 유효하지 않다면 예외 발생
     * @param name 이름
     * @throws Validate.InvalidNameLength 유효하지 않은 이름일 때의 예외
     */
    static void checkName(String name) throws Validate.InvalidNameLength {
        String trimedName = name.trim();
        if (!validNameLength(trimedName)) {
            throw new InvalidNameLength();
        }
    }

    /**
     * 숫자가 유효한 범위인지(0 이상) 검증
     * @param number 숫자: 횟수
     * @return 유효하면 true
     */
    static boolean validNumber(int number) {
        return number >= 0;
    }
}