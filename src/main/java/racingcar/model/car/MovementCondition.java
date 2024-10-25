package racingcar.model.car;

import static racingcar.common.constant.RaceConstant.MIN_SPEED_TO_MOVE;

import java.util.Arrays;
import java.util.function.Predicate;
import racingcar.model.position.Distance;

public enum MovementCondition {

    FORWARD(Distance.ONE, (speed) -> speed >= MIN_SPEED_TO_MOVE),
    NONE(Distance.ZERO, (speed) -> speed < MIN_SPEED_TO_MOVE);

    private final Distance distance;
    private final Predicate<Integer> predicate;

    MovementCondition(final Distance distance, final Predicate<Integer> predicate) {
        this.distance = distance;
        this.predicate = predicate;
    }

    public Distance getDistance() {
        return distance;
    }

    public static MovementCondition getConditionBy(int movementValue) {
        return Arrays.stream(MovementCondition.values())
                .filter(val -> val.predicate.test(movementValue))
                .findFirst()
                .orElse(NONE);
    }
}
