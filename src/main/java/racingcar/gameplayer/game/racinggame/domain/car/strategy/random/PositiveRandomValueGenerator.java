package racingcar.gameplayer.game.racinggame.domain.car.strategy.random;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.gameplayer.game.common.domain.PositiveNumber;

public class PositiveRandomValueGenerator implements RandomValueGenerator {

    private static final int RANDOM_START_NUM = 0;
    private static final int RANDOM_END_NUM = 9;

    public PositiveNumber generate() {
        return new PositiveNumber(Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM));
    }
}
