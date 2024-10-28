package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(","));
    }
}
