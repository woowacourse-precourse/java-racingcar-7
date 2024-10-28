package racingcar.controller.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private final int minValue;
    private final int maxValue;
    private final int movableValue;

    public RandomMoveStrategy(final int minValue, final int maxValue, final int movableValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.movableValue = movableValue;
    }

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(minValue, maxValue) >= movableValue;
    }
}
