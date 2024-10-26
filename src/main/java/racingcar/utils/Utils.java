package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    public static String[] splitDelimiterCars(String input) {
        return input.split(",");
    }

    public static boolean advanceConditions() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}