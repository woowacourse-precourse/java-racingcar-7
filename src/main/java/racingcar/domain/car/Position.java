package racingcar.domain.car;

import racingcar.domain.validator.PositionValidator;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private final int value;
    private final PositionValidator validator;

    public Position() {
        this(INITIAL_POSITION);
    }

    private Position(int value) {
        this.validator = new PositionValidator();
        this.validator.validate(value);
        this.value = value;
    }

    public Position forward() {
        return new Position(value + 1);
    }

    public boolean isSameAs(Position other) {
        return this.value == other.value;
    }
}