package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public Integer getRandomNumber(Integer min, Integer max) {
        return Randoms.pickNumberInRange(min,max);
    }
}
