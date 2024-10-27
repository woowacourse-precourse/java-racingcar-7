package racingcar.car.strategy;

import racingcar.util.NumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int MOVE_ONCE = 1;
    private static final int STOP = 0;

    private final NumberGenerator numberGenerator;

    public RandomMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getPossibleMoveAmount() {
        int pickedNumber = numberGenerator.generate();
        if (pickedNumber >= MOVE_CONDITION_NUMBER) {
            return MOVE_ONCE;
        }

        return STOP;
    }
}
