package racingcar.domain.car;

import racingcar.util.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int CAN_MOVE_CONDITION = 4;

    @Override
    public boolean canMove() {
        int randomValue = RandomNumberGenerator.generate();
        return randomValue >= CAN_MOVE_CONDITION;
    }

}