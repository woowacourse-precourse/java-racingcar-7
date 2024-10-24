package racingcar.model.car;

import static racingcar.common.constant.RaceConstant.FORWARD_MOVEMENT;
import static racingcar.common.constant.RaceConstant.MIN_SPEED_TO_MOVE;
import static racingcar.common.constant.RaceConstant.NO_MOVEMENT;

import java.util.Arrays;
import java.util.function.Predicate;
import racingcar.util.random.IRandomUtil;
import racingcar.util.random.RandomUtilFactory;

public enum MovementCondition {

    FORWARD(FORWARD_MOVEMENT, (speed) -> speed >= MIN_SPEED_TO_MOVE),
    NONE(NO_MOVEMENT, (speed) -> speed < MIN_SPEED_TO_MOVE);

    private final int distance;
    private final Predicate<Integer> predicate;

    MovementCondition(final int distance, final Predicate<Integer> predicate) {
        this.distance = distance;
        this.predicate = predicate;
    }

    public int getDistance() {
        return distance;
    }

    public static MovementCondition getCondition() {
        IRandomUtil randomUtil = RandomUtilFactory.getUtil();
        int speed = randomUtil.generateRandomNum();
        return Arrays.stream(MovementCondition.values())
                .filter(val -> val.predicate.test(speed))
                .findFirst()
                .orElse(NONE);
    }

    public boolean carCanMove() {
        return this == FORWARD;
    }
}
