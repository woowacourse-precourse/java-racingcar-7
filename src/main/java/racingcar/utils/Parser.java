package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public final class Parser {
    private static final String COMMA_STRING = ",";
    public static List<String> convertStringToList(String string) {
        return Arrays.asList(string.split(COMMA_STRING));
    }

}
