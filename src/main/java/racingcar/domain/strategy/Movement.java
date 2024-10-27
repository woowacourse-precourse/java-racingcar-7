package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public enum Movement {

    STOP(3),
    RANDOM(Randoms.pickNumberInRange(0, 9)),
    MOVE(4),
    ;

    public final int value;

    Movement(int value) {
        this.value = value;
    }
}
