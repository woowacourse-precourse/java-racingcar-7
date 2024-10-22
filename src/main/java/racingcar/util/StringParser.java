package racingcar.util;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class StringParser {

    private final static String[] NAME_DELIMITERS = {","};
    private final static int MAX_NAME_LENGTH = 5;

    public static Set<String> parseCarName(final String str) {
        Set<String> names = Arrays.stream(buildDelimiterRegex().split(str))
                .map(String::trim)
                .collect(Collectors.toSet());

        if (names.size() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 " + MAX_NAME_LENGTH + "이하여야 합니다.");
        }

        return names;
    }

    private static Pattern buildDelimiterRegex() {
        String regex = Pattern.quote(String.join("|", NAME_DELIMITERS));

        return Pattern.compile(regex);
    }
}
