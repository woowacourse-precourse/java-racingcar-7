package racingcar;

public final class Validator {
    private Validator() {
    } // Util Class

    public static void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("적어도 한 대의 자동차 이름을 입력해야 합니다.");
        }
        for (String name : names) {
            validateCarName(name);
        }
    }

    private static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }
}
