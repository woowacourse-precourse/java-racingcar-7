package racingcar.executor.generator.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomIntegerGenerator {
    public static int run() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
