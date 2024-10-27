package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Utils {

    public static List<String> splitDelimiterCars(String input) {
        return List.of(input.split(","));
    }

    public static boolean advanceConditions() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}