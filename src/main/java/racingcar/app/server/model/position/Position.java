package racingcar.app.server.model.position;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.DISTANCE_SHOULD_NOT_BE_MINUS;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Position {

    public static Position ON_START_LINE = initiate();
    private static final String INITIAL_POSITION = "";

    private final String value;

    private Position(final String value) {
        this.value = value;
    }

    private static Position initiate() {
        return new Position(INITIAL_POSITION);
    }

    public static Position from(String source) {
        requireNonNull(source, SHOULD_NOT_BE_NULL);
        return new Position(source.strip());
    }

    public Position add(final Distance distance) {
        Distance destination = currentDistance().add(distance);
        if (destination.isLowerThanZero()) {
            throw new ShouldNotBeMinusException(DISTANCE_SHOULD_NOT_BE_MINUS);
        }
        return PositionBuilder.from(destination);
    }

    public Distance currentDistance() {
        return Distance.from(value.length());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position oPosition = (Position) obj;
        return Objects.equals(this.value, oPosition.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
