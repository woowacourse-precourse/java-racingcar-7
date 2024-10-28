package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.IntSupplier;

public class RandomEngine {

    private RandomEngine() {}

    public static IntSupplier getEngine() {
        return () -> Randoms.pickNumberInRange(0, 9);
    }
}
