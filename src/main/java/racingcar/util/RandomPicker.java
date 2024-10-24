package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPicker {
    public RandomPicker() {
    }

    public int pickNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
