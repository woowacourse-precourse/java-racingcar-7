package racingcar.view;

public enum ViewConstants {
    WINNER_POSITION(5);

    private int value;

    ViewConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
