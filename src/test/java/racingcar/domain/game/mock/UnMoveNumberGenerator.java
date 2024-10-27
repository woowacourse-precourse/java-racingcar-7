package racingcar.domain.game.mock;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.game.NumberGenerator;

public class UnMoveNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return pickNumberInRange(0, 3);
    }
}
