package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int FORWARD_CONDITION_NUMBER = 4;
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    @Override
    public boolean isMoving() {
        return getRandomNumber() >= FORWARD_CONDITION_NUMBER;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
