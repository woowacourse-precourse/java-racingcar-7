package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}