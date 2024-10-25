package racingcar.strategy;

import racingcar.util.RandomPicker;

public class RandomMoveStrategy implements MoveStrategy {

    private final RandomPicker randomPicker;

    public RandomMoveStrategy(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    @Override
    public boolean canMove() {
        return randomPicker.pickNumberInRange(0, 9) >= 4;
    }
}
