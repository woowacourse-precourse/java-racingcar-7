package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
