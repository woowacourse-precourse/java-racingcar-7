package racingcar.model.policy;

import racingcar.model.Car;

public class CarMovePolicy implements MovementPolicy {

    private final MoveConditionPolicy moveConditionPolicy;

    public CarMovePolicy(MoveConditionPolicy moveConditionPolicy) {
        this.moveConditionPolicy = moveConditionPolicy;
    }

    @Override
    public void move(Car car) {
        if (moveConditionPolicy.isMovable()) {
            car.move(1);
        }
    }
}
