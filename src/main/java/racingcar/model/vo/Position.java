package racingcar.model.vo;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private static final int INCREMENT_VALUE = 1;
    private int value;

    public Position() {
        this.value = DEFAULT_POSITION;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        this.value += INCREMENT_VALUE;
    }
}
