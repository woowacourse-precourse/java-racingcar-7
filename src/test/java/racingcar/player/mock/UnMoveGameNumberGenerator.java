package racingcar.player.mock;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.game.GameNumberGenerator;

public class UnMoveGameNumberGenerator implements GameNumberGenerator {
    @Override
    public int generate() {
        return pickNumberInRange(0, 3);
    }
}
