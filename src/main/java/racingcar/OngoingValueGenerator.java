package racingcar;

import static racingcar.OngoingValue.MAX_INCLUDE_BOUND;
import static racingcar.OngoingValue.MIN_INCLUDE_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class OngoingValueGenerator {

    public OngoingValue generate() {
        int randomNumber = Randoms.pickNumberInRange(MIN_INCLUDE_BOUND, MAX_INCLUDE_BOUND);
        return OngoingValue.from(randomNumber);
    }
}
