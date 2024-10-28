package racingcar.model;

import racingcar.model.strategy.IntGeneratorStrategy;

public class Car {
    private static final int MINIMUM_CAN_MOVE_CONDITION = 4;
    private static final int ONE_FORWARD_MOVE_DISTANCE = 1;
    private final IntGeneratorStrategy intGeneratorStrategy;
    private final String carName;
    private int position;

    public Car(String carName, IntGeneratorStrategy randomIntGeneratorStrategy) {
        this.intGeneratorStrategy = randomIntGeneratorStrategy;
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove() {
        if (canMove()) {
            doMove();
        }
    }

    private boolean canMove() {
        return intGeneratorStrategy.getIntValue() >= MINIMUM_CAN_MOVE_CONDITION;
    }

    private void doMove() {
        position += ONE_FORWARD_MOVE_DISTANCE;
    }
}

