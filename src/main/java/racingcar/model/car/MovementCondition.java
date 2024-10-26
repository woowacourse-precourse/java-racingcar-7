package racingcar.model.car;

import static racingcar.common.constant.RaceConstant.MIN_SPEED_TO_MOVE;

import java.util.Arrays;
import java.util.function.BiPredicate;
import racingcar.model.position.Distance;

public enum MovementCondition {

    FORWARD(Distance.ONE, (speed, minSpeed) -> speed >= minSpeed),
    NONE(Distance.ZERO, (speed, minSpeed) -> speed < minSpeed);

    private final Distance distance;
    private final BiPredicate<Integer, Integer> predicate;

    MovementCondition(final Distance distance, final BiPredicate<Integer, Integer> predicate) {
        this.distance = distance;
        this.predicate = predicate;
    }

    public Distance getDistance() {
        return distance;
    }

    public static MovementCondition getConditionBy(int movementValue) {
        return Arrays.stream(MovementCondition.values())
                .filter(val -> val.predicate.test(movementValue, MIN_SPEED_TO_MOVE))
                .findFirst()
                .orElse(NONE);
    }
}
