package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final String DELIMITER = ",";
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;


    public static int generateRandomValue() {
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
    }

    public static List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
