package racingcar.domain.mover;

import racingcar.domain.mover.policy.MovePolicy;
import racingcar.domain.Car;

public class CarMover {

    private final MovePolicy movePolicy;

    public CarMover(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void run(final Car car) {
        if (movePolicy.canMove()) {
            car.move();
        }
    }

}
