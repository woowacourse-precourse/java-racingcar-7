package racingcar.car;

import static racingcar.car.MovementPolicy.INITIAL_POSITION;
import static racingcar.car.MovementPolicy.MAX_STEP;
import static racingcar.car.MovementPolicy.MIN_STEP;
import static racingcar.car.exception.MovementException.*;

import racingcar.car.exception.MovementException;

public class MovementDistance {

    private final int value;

    public MovementDistance(int value) {
        this.value = value;
    }

    public static MovementDistance initializeDistance() {
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
