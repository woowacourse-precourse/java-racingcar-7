package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public int generateRandomValueInRange() {
        final int startRange = 0;
        final int endRange = 9;
        return Randoms.pickNumberInRange(startRange,endRange);
    }

}
