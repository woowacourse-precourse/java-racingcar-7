package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    @Override
    public boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

}