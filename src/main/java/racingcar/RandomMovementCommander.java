package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
