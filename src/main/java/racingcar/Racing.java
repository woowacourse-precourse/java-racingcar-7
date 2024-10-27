package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.RaceConfig.RANDOM_END_NUMBER;
import static racingcar.RaceConfig.RANDOM_START_NUMBER;

public class Racing {

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
    }
}
