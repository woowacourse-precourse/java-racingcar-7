package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public interface RaceRandomGenerator {
    long getMoveForwardTimes(long raceTimes);

    default int getRandomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
