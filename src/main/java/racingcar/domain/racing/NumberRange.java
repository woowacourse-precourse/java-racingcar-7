package racingcar.domain.racing;

public enum NumberRange {

    RANDOM_NUMBER_RANGE(0, 9);

    private final int start;
    private final int end;

    NumberRange(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

}
