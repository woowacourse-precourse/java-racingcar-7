package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final static int randomStartNumber = 0;
    private final static int randomLastNumber = 9;
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(randomStartNumber,randomLastNumber);
    }
}
