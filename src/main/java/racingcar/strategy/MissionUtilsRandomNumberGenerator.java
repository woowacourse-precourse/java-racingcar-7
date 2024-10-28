package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionUtilsRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
