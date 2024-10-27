package racingcar.model;

public class TryCount {

    private final int count;

    private TryCount(int count) {
        validateRange(count);
        this.count = count;
    }

    public static TryCount from(String input) {
        validateNumeric(input);
        validateEmpty(input);
        return new TryCount(Integer.parseInt(input));
    }

    public int getCount() {
        return count;
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수에 빈 값을 입력할 수 없습니다.");
        }
    }

    private void validateRange(int count) {
        if (count < 1 || count > 10) {
            throw new IllegalArgumentException("입력 가능한 시도 횟수 범위는 1 ~ 10입니다.");
        }
    }
}
