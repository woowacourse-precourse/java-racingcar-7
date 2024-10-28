package racingcar;

import racingcar.domain.MoveCondition;

public class ForwardMoveCondition implements MoveCondition {

    @Override
    public boolean canMove() {
        return true;
    }
}
