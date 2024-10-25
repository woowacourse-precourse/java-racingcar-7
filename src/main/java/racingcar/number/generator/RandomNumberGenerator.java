package racingcar.number.generator;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.global.constant.Config.MAX_GENERATE_NUMBER;
import static racingcar.global.constant.Config.MIN_GENERATE_NUMBER;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public int generateNumber() {
        return generateRandomNumber();
    }

    private int generateRandomNumber() {
        return pickNumberInRange(MIN_GENERATE_NUMBER, MAX_GENERATE_NUMBER);
    }
}
