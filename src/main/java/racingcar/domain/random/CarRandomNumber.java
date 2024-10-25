package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRandomNumber implements RandomNumberGenerator{

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 10;

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
