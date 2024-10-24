package racingcar.model;

public enum RandomRange {
    MIN(0), MAX(9);

    private final int number;

    RandomRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
