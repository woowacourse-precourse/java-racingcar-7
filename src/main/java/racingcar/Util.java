package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

import static racingcar.Constants.*;

public class Util {
    public static int getMax(ArrayList<Integer> integers) {
        return Collections.max(integers);
    }

    public static int randomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
