package racingcar.validation;

public class ValidationGameCount {
    public static int validateGameCount(String gameCount) {
        int attempt;
        try {
            attempt = Integer.parseInt(gameCount);
            validNegativeNumber(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0~2^31-1의 정수로만 횟수를 입력하세요(문자, 소수 불가).");
        }
        return attempt;
    }

    public static void validNegativeNumber(int attempt) {
        if (attempt < 0) {
            throw new IllegalArgumentException("음수로는 시도 횟수를 측정하지 못합니다.");
        }
    }
}
