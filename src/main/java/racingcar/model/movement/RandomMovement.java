package racingcar.model.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements Movement {

    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MOVE_MIN_NUMBER = 4;

    @Override
    public boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= MOVE_MIN_NUMBER) {
            return true;
        }
        return false;
    }
}
