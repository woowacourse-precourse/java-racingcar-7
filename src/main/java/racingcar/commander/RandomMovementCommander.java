package racingcar.commander;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveCommand;

public class RandomMovementCommander implements MovementCommander {
    @Override
    public MoveCommand moveCommand() {
        if (random() < 4) {
            return MoveCommand.STOP;
        }
        return MoveCommand.MOVE;
    }

    private int random() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
