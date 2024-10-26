package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Rule {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVEMENT_CONDITION = 4;

    public boolean shouldMove(int randomNumber) {
        return randomNumber >= MOVEMENT_CONDITION;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
