package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static racingcar.Constants.*;

public class Util {
    public static int getMax(ArrayList<Integer> integers) {
        return Collections.max(integers);
    }

    public static ArrayList<String> toArrayList(String carsString) {
        return new ArrayList<>(Arrays.asList(carsString.split(",")));
    }

    public static int toInt(String roundString) {
        return Integer.parseInt(roundString);
    }

    public static int randomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
