package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {

    public int parseAttemptCount(String inputAttemptCount) {
        return Integer.parseInt(inputAttemptCount);
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
