package racingcar.car.exception;

import racingcar.RacingCarException;

public class MovementException extends RacingCarException {
    public MovementException(String message) {
        super(message);
    }

    public static class MinimumStepException extends MovementException {
        public MinimumStepException() {
            super("이동 거리는 최소 1스텝 이상 가능합니다.");
        }
    }

    public static class MaximumStepException extends MovementException {
        public MaximumStepException() {
            super("이동 거리는 최대 100스텝 까지만 가능합니다.");
        }
    }
}