package racingcar.domain;

import racingcar.dto.MovementNumber;

public class MovementPolicy {
    private final int number;

    public MovementPolicy(MovementNumber number) {
        this.number = number.value();
    }

    public boolean shouldMove() {
        return satisfiesMovementCondition();
    }

    private boolean satisfiesMovementCondition() {
        return number >= 4;
    }
}
