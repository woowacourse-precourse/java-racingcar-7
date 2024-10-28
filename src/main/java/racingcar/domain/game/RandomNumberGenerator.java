package racingcar.domain.game;

import static racingcar.constant.GameConstants.RANDOM_NUMBER_MAX;
import static racingcar.constant.GameConstants.RANDOM_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}
