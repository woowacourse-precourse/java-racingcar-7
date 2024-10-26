package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceService {

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
