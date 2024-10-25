package racingcar.player.mock;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.game.GameNumberGenerator;

public class CanMoveGameNumberGenerator implements GameNumberGenerator {
    @Override
    public int generate() {
        return pickNumberInRange(4,9);
    }
}
