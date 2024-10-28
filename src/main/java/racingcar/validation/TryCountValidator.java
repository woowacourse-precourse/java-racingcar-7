package racingcar.validation;

public class TryCountValidator {
    public static int validate(String tryCountInput) {
        int tryCount = parseTryCount(tryCountInput);
        validatePositiveTryCount(tryCount);
        return tryCount;
    }

    private static int parseTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("실행 횟수는 정수 형태여야 합니다.");
        }
    }

    private static void validatePositiveTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("실행 횟수는 0보다 큰 정수여야 합니다.");
        }
    }
}
