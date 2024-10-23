package racingcar.model.race;

import static racingcar.common.constant.RaceConstant.NO_MOVEMENT;
import static racingcar.common.constant.RaceConstant.POSITION_ICON;
import static racingcar.common.constant.SystemConstant.EMPTY_STRING;

import java.util.stream.IntStream;

public class Position {
    private String value;

    public static Position initiate() {
        return new Position();
    }

    private Position() {
        this.value = EMPTY_STRING;
    }

    public void add(final int moveDistance) {
        if (moveDistance == NO_MOVEMENT) {
            return;
        }
        this.value = generateNextPosition(moveDistance);
    }

    // TODO : Util로 가져가야 할까?
    private String generateNextPosition(final int moveDistance) {
        StringBuilder positionBuilder = new StringBuilder(this.value);
        IntStream.range(0, moveDistance)
                .forEach(idx -> positionBuilder.append(POSITION_ICON));
        return positionBuilder.toString();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
