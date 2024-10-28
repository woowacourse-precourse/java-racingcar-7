package racingcar.external;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
