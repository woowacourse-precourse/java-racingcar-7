package racingcar.model.car;

import racingcar.utils.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int CAN_MOVE_NUMBER_MIN = 4;

    @Override
    public boolean canMove() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        return randomNumber >= CAN_MOVE_NUMBER_MIN;
    }
}
