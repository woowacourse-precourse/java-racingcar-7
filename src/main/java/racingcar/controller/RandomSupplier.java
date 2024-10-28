package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class RandomSupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
