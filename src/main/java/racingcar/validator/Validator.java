package racingcar.validator;

public class Validator {

    private Validator() {
    }

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateGameCount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}