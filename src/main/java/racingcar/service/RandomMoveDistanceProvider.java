package racingcar.service;

import static racingcar.util.Constant.MAX_RANDOM_VALUE;
import static racingcar.util.Constant.MIN_RANDOM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveDistanceProvider implements MoveDistanceProvider {
    @Override
    public Integer generateMoveDistance() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
