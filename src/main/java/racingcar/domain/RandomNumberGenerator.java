package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}