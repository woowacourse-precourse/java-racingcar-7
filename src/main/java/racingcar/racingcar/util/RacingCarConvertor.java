package racingcar.racingcar.util;

import java.util.Arrays;
import java.util.List;

public class RacingCarConvertor {
    public static List<String> splitByCommaToList(String input) {

        return Arrays.stream(splitByComma(input))
                .toList();
    }
    private static String[] splitByComma(String input) {
        return input.split(",");
    }
}
