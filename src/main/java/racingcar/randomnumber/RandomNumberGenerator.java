package racingcar.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int RandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
