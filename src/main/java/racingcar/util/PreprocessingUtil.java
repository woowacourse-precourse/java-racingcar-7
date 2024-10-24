package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class PreprocessingUtil {

    public static List<String> stringToStringList(final String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .map(val -> val.replaceAll("\\s", ""))
                .toList();
    }

    public static String replaceAllUnNecessaryChar(final String source) {
        return source.replaceAll("[\\s|(^0+)]", "");
    }
}
