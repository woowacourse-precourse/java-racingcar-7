package racingcar.utils.moving;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingByRandomNumber implements MovingStrategy{

    private static final int MOVE_THRESHOLD = 4;

    public boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}
