package racingcar.domain.car;

public class Position {
    private static final int START_POSITION = 0;
    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(START_POSITION);
    }

}
