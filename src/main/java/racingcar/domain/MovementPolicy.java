package racingcar.domain;

import racingcar.dto.MovementValue;

public class MovementPolicy {
    private final int number;

    public MovementPolicy(MovementValue number) {
        this.number = number.value();
    }

    public boolean shouldMove() {
        return satisfiesMovementCondition();
    }

    private boolean satisfiesMovementCondition() {
        return number >= 4;
    }
}
