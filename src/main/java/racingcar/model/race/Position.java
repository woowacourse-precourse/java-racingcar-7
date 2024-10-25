package racingcar.model.race;

import static racingcar.common.constant.RaceConstant.POSITION_ICON;
import static racingcar.common.constant.SystemConstant.EMPTY_STRING;

public class Position {
    private String value;

    public static Position initiate() {
        return new Position();
    }

    private Position() {
        this.value = EMPTY_STRING;
    }

    public void add(final Distance distance) {
        if (distance.isZero()) {
            return;
        }
        this.value = generateNextPosition(distance);
    }

    private String generateNextPosition(final Distance distance) {
        StringBuilder positionBuilder = new StringBuilder(this.value);
        distance.initiateIntStream()
                .forEach(idx -> positionBuilder.append(POSITION_ICON));
        return positionBuilder.toString();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
