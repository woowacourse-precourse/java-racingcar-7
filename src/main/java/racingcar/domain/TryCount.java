package racingcar.domain;

public class TryCount {

    private Integer count;

    public TryCount() {
    }

    public void set(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
