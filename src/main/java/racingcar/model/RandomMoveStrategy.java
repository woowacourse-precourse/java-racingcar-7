package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy {
    private static final int MOVE_THRESHOLD = 4;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
