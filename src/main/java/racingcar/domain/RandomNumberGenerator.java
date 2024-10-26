package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MINIMUM_NUM = 0;
    private static final int MAXIMUM_NUM = 9;

    @Override
    public int generateNumber() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUM, MAXIMUM_NUM);

        return randomNumber;
    }
}
