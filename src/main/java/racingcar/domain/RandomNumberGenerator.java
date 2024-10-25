package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        int randomNumber=Randoms.pickNumberInRange(0, 9);

        return randomNumber;
    }
}
