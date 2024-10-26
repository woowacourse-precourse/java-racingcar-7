package racingcar.model;

public class AttemptCount {
    private int count;

    private AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        return new AttemptCount(count);
    }

    public void decrease() {
        count--;
    }
}
