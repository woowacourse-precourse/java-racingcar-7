package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements Generator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
