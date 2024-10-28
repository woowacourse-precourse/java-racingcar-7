package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementJudge implements MovementJudge {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int RUN_NUMBER = 4;

    @Override
    public boolean isMovable() {
        int random = Randoms.pickNumberInRange(MIN, MAX);
        return random >= RUN_NUMBER;
    }
}
