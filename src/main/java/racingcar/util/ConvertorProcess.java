package racingcar.util;

import racingcar.constant.separator.SeparatorConstant;

import java.util.Arrays;
import java.util.List;

public class ConvertorProcess {
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
    public static List<String> splitByCommaToList(String input) {

        return Arrays.stream(splitByComma(input))
                .toList();
    }
    private static String[] splitByComma(String input) {
        return input.split(SeparatorConstant.COMMA);
    }
}
