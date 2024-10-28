package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public boolean goAndStop(){
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
