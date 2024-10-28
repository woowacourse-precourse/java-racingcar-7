package racingcar.service;

import racingcar.constant.Constants;

public class MoveCountService {
    private int moveCount;

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(String moveCountStr) {
        int moveCount;
        try {
            moveCount = Integer.parseInt(moveCountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_MOVE_COUNT_NUMBER);
        }

        if (moveCount < 1) {
            throw new IllegalArgumentException(Constants.INVALID_MOVE_COUNT);
        }
        this.moveCount = moveCount;
    }
}
