package racingcar.fake;

import racingcar.constant.Rule;
import racingcar.util.generator.NumberGenerator;

public class ForwardNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Rule.CAR_FORWARD_CONDITION + 1;
    }
}
