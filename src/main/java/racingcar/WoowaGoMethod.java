package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class WoowaGoMethod implements GoMethod {

    private static final int GO_STANDARD = 4;
    private static final int MINIMUM_RANDOM_RANGE = 0;
    private static final int MAXIMUM_RANDOM_RANGE = 9;

    private int tryGo () {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_RANGE, MAXIMUM_RANDOM_RANGE);
    }

    @Override
    public boolean canIGo() {
        int goForward = tryGo();

        return goForward >= GO_STANDARD;
    }
}
