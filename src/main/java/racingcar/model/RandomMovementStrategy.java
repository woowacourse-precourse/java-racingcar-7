package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {

    @Override
    public boolean moveable() {
        return makeRandomNumber() >= 4;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


}
