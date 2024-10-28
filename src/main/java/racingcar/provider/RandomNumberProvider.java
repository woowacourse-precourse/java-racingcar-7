package racingcar.provider;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider implements NumberProvider {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    @Override
    public int getNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
