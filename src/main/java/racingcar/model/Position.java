package racingcar.model;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public int toInteger() {
        return this.position;
    }
}
