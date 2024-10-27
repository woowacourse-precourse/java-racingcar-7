package racingcar.constant;

public enum CarStatus {

    INITIAL_STATE(0);

    private int value;

    private CarStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
