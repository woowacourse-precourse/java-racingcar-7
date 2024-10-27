package racingcar.model;

public class TryCount {
    private final int count;

    private TryCount(int count) {
        validate(count);
        this.count = count;
    }

    @Override
    public String toString() {
        return count + "";
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        validateRange(count);
    }

    private void validateRange(int count) {
        if (count < 1 || count > 10) {
            throw new IllegalArgumentException("입력 가능한 시도 횟수 범위는 1 ~ 10입니다.");
        }
    }
}
