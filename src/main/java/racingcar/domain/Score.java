package racingcar.domain;

public class Score {

    private int value;

    public Score(final int value) {
        this.value = value;
    }

    public void addValue(final int value) {
        this.value += value;
    }

    public int getValue() {
        return value;
    }
}
