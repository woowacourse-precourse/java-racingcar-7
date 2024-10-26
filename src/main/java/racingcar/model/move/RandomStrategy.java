package racingcar.model.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        int randomInt = Randoms.pickNumberInRange(0, 9);

        if (randomInt >= 4) {
            return true;
        }

        return false;
    }
}
