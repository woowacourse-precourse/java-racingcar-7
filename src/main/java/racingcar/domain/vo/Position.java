package racingcar.domain.vo;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

import java.util.Objects;

public class Position {

    public static final int MOVABLE = 1;

    private final Integer value;

    public Position(Integer position) {
        validatePosition(position);
        this.value = position;
    }

    public Integer getValue() {
        return value;
    }

    public Position move() {
        return new Position(value + MOVABLE);
    }

    private static void validatePosition(Integer position) {
        if (position < 0) {
            throw new BusinessException(RacingCarExceptionMessage.POSITION_MUST_BE_INTEGER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return Objects.equals(value, position.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
