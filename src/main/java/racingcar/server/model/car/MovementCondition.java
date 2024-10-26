package racingcar.server.model.car;

import static racingcar.server.model.car.Speed.MIN_SPEED;

import java.util.Arrays;
import java.util.function.BiPredicate;
import racingcar.server.model.position.Distance;

public enum MovementCondition {

    FORWARD(Distance.ONE, Speed::foeThan),
    NONE(Distance.ZERO, Speed::slowerThan);

    private final Distance distance;
    private final BiPredicate<Speed, Speed> predicate;

    MovementCondition(final Distance distance, final BiPredicate<Speed, Speed> predicate) {
        this.distance = distance;
        this.predicate = predicate;
    }

    public static Distance getDistanceBy(final Speed speed) {
        MovementCondition movementCondition = Arrays.stream(MovementCondition.values())
                .filter(condition -> condition.predicate.test(speed, MIN_SPEED))
                .findFirst()
                .orElse(NONE);
        return movementCondition.distance;
    }
}
