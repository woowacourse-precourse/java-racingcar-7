package racingcar.fake;

import racingcar.constant.Rule;
import racingcar.util.NumberGenerator;

public class StopNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Rule.CAR_FORWARD_CONDITION - 1;
    }
}
