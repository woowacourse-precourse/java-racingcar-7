package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomGenerator {
    @Override
    public int getRandomSingleDigit(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
