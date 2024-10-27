package racingcar.domain.game.mock;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.game.NumberGenerator;

public class CanMoveNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return pickNumberInRange(4, 9);
    }
}
