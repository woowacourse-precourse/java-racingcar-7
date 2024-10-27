package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    @Override
    public int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}