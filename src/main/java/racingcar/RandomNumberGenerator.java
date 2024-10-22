package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static boolean isFollowNumberRule() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
