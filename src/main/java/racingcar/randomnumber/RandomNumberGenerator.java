package racingcar.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.GetRandomNumber;

public class RandomNumberGenerator implements GetRandomNumber {

    @Override
    public boolean isRandomNumberAgainstRule() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return (randomNumber < 4);
    }
}
