package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ConvertingUtil {

    private ConvertingUtil() {
    }

    public static List<String> stringToStringList(final String source, final String delimiter) {
        return Arrays.stream(source.split(delimiter))
                .map(String::strip)
                .toList();
    }
}
