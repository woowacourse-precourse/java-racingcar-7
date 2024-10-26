package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
