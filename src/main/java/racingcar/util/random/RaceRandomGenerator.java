package racingcar.util.random;

import camp.nextstep.edu.missionutils.Randoms;

public interface RaceRandomGenerator {
    boolean canMoveForward();

    default int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
