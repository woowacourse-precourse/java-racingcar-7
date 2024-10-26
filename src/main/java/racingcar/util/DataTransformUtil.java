package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class DataTransformUtil {

    public List<String> splitInput(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter)).toList();
    }

    public int parseToInt(final String value) {
        return Integer.parseInt(value);
    }
}
