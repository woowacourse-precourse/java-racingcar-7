package service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 5;
    private final int random;

    public RandomMoveStrategy() {
        this.random = Randoms.pickNumberInRange(0,9);
    }

    @Override
    public boolean canMove() {
        return random >= MOVE_THRESHOLD;
    }
}
