package racingcar.util;

import static racingcar.common.Constant.EMPYT_STRING;

import java.util.Arrays;
import java.util.List;

public class PreprocessingUtil {

    public static List<String> stringToStringList(final String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .map(val -> val.replaceAll("\\s", EMPYT_STRING))
                .toList();
    }

    public static String replaceAllUnNecessaryChar(final String source) {
        String cleanedWhiteSpaceSource = source.replaceAll("\\s", EMPYT_STRING);
        return cleanedWhiteSpaceSource.replaceAll("(^0+)", EMPYT_STRING);
    }
}
