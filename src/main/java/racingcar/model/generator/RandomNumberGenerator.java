package racingcar.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
