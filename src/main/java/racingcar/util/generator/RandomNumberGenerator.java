package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Rule;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Rule.RANDOM_NUMBER_MIN, Rule.RANDOM_NUMBER_MAX);
    }
}
