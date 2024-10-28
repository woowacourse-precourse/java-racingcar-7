package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constants;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(Constants.RANDOM_MIN, Constants.RANDOM_MAX);
    }
}
