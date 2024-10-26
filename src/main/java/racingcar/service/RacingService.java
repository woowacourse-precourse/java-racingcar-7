package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    public boolean isAdvanceByRandom() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
