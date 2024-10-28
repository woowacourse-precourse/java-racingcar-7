package racingcar.app.server.model.car;

import static racingcar.app.server.model.car.Speed.MIN_SPEED;

import java.util.Arrays;
import java.util.function.BiPredicate;
import racingcar.app.server.model.location.Distance;

public enum MovementCondition {

    FORWARD(Distance.ONE, Speed::foeThan),
    NONE(Distance.ZERO, Speed::slowerThan);

    private final Distance movalbleDistance;
    private final BiPredicate<Speed, Speed> predicate;

    MovementCondition(final Distance movalbleDistance, final BiPredicate<Speed, Speed> predicate) {
        this.movalbleDistance = movalbleDistance;
        this.predicate = predicate;
    }

    public static Distance getMovableDistanceBy(final Speed speed) {
        MovementCondition movementCondition = Arrays.stream(MovementCondition.values())
                .filter(condition -> condition.predicate.test(speed, MIN_SPEED))
                .findFirst()
                .orElse(NONE);
        return movementCondition.movalbleDistance;
    }
}
