package racingcar;

import static racingcar.GoingValue.MAX_INCLUDE_BOUND;
import static racingcar.GoingValue.MIN_INCLUDE_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class GoingValueGenerator {

    public GoingValue generate() {
        int randomNumber = Randoms.pickNumberInRange(MIN_INCLUDE_BOUND, MAX_INCLUDE_BOUND);
        return GoingValue.from(randomNumber);
    }
}
