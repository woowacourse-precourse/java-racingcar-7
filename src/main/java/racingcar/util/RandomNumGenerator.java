package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator implements Generator{

    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
