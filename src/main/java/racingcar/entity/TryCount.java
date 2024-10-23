package racingcar.entity;

public class TryCount {

    private final Long maxCount;
    private Long count;

    public TryCount(String input) {
        long maxCount;

        try {
            maxCount = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자여야 합니다.");
        }

        if (maxCount < 0) {
            throw new IllegalArgumentException("0보다 작으면 안됩니다.");
        }

        this.maxCount = maxCount;
        this.count = 0L;
    }

    // while 문에서 동작하는
    public boolean canTry() {
        if (count < maxCount) {
            count++;
            return true;
        }
        return false;
    }


}
