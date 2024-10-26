package racingcar.domain;

public class Score {

    private long value;

    public Score(final long value) {
        this.value = value;
    }

    public void addValue(final long value) {
        this.value += value;
    }

    public long getValue() {
        return value;
    }
}
