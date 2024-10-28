package racingcar.app.server.model.location;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.DISTANCE_SHOULD_NOT_BE_MINUS;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;
import java.util.stream.LongStream;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Position {

    private static final String POSITION_ICON = "-";

    private final String value;

    private Position(final String value) {
        this.value = value;
    }

    public static Position from(String source) {
        requireNonNull(source, SHOULD_NOT_BE_NULL);
        return new Position(source.strip());
    }

    public static Position fromDistance(long distance) {
        validateIsMinus(distance);

        StringBuilder positionBuilder = new StringBuilder();
        LongStream.range(0, distance)
                .forEach(idx -> positionBuilder.append(POSITION_ICON));

        return Position.from(positionBuilder.toString());
    }

    private static void validateIsMinus(long distance) {
        if (distance < 0) {
            throw new ShouldNotBeMinusException(DISTANCE_SHOULD_NOT_BE_MINUS);
        }
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

    @Override
    public String toString() {
        return this.value;
    }
}
