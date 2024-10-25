package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumStrategy implements MoveStrategy{
    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
