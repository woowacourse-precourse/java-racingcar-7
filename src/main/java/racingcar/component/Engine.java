package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {

    private static final int START_MIN_NUMBER = 4;

    public boolean start() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= START_MIN_NUMBER;
    }

}
