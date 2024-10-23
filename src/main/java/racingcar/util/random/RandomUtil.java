package racingcar.util.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil implements IRandomUtil {

    @Override
    public int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
