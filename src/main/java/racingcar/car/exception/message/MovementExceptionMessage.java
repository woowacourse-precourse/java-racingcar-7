package racingcar.car.exception.message;

import racingcar.car.policy.MovementPolicy;

public class MovementExceptionMessage {
    private MovementExceptionMessage() {
    }

    public static final String MIN_STEP_REQUIRED =
            String.format("이동 거리는 최소 %d스텝 이상 가능합니다.", MovementPolicy.MIN_STEP);

    public static final String MAX_STEP_EXCEEDED =
            String.format("이동 거리는 최대 %d스텝 까지만 가능합니다.", MovementPolicy.MAX_STEP);


}
