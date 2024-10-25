package racingcar.domain;

public class TryCount {

    private int count;

    public TryCount(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
