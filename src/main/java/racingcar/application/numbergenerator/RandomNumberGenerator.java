package racingcar.application.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public boolean isFollowNumberRule() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
