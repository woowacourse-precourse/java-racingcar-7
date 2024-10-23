package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.Config.MAX_RANDOM_NUMBER;
import static racingcar.constants.Config.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int getNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
