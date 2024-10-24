package racingcar.car.exception;

import racingcar.car.exception.message.MovementExceptionMessage;
import racingcar.common.exception.RacingCarException;

public class MovementException extends RacingCarException {
    public MovementException(String message) {
        super(message);
    }

    public static class MinimumStepException extends MovementException {
        public MinimumStepException() {
            super(MovementExceptionMessage.MIN_STEP_REQUIRED);
        }
    }

    public static class MaximumStepException extends MovementException {
        public MaximumStepException() {
            super(MovementExceptionMessage.MAX_STEP_EXCEEDED);
        }
    }
}