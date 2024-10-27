package racingcar.model.Car.move;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class Move {
    private static final int RandomMinValue = 0;
    private static final int RandomMaxValue = 9;

    protected int moveByRandom() {
        Randoms randoms = null;
        return randoms.pickNumberInRange(RandomMinValue, RandomMaxValue);
    }

}
