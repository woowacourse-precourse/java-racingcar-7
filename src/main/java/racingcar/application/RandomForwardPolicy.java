package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.ForwardPolicy;

public class RandomForwardPolicy implements ForwardPolicy {

    @Override
    public boolean forward() {
        return 4 <= Randoms.pickNumberInRange(0, 9);
    }
}
