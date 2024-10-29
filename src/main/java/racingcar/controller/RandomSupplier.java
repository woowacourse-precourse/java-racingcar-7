package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class RandomSupplier implements Supplier<Integer> {
    private final int min;
    private final int max;

    public RandomSupplier(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer get() {
        return Randoms.pickNumberInRange(min, max);
    }
}
