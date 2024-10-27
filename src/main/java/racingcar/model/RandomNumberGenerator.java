package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.NumberConstants;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
    }
}
