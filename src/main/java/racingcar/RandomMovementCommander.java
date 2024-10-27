package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementCommander implements MovementCommander {
    @Override
    public MoveCommand moveCommand() {
        return null;
    }

    private int random() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
