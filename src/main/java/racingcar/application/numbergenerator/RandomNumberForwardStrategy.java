package racingcar.application.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.ForwardStrategy;

public class RandomNumberForwardStrategy implements ForwardStrategy {

    @Override
    public boolean isMovingForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
