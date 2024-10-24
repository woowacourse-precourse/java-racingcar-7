package racingcar.car;

import static racingcar.car.exception.MovementException.*;

import racingcar.car.exception.MovementException;

public class MovementDistance {
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 100;
    private final int value;

    public MovementDistance(int value) {
        this.value = value;
    }

    public static MovementDistance initialzeDistance() {
        return new MovementDistance(INITIAL_POSITION);
    }

    public MovementDistance increaseDistanceBy(int stepCount) {
        if(stepCount < MIN_STEP){
                throw new MinimumStepException();
        }
        if(stepCount > MAX_STEP){
                throw new MovementException.MaximumStepException();
        }
        return new MovementDistance(this.value + stepCount);
    }

    public int getValue() {
        return this.value;
    }
}
