package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPicker {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
