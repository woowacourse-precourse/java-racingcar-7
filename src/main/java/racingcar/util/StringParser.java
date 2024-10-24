package racingcar.util;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class StringParser {

    public final static String NAME_DELIMITER = ",";
    public final static int MAX_NAME_LENGTH = 5;

    public static Set<String> parseCarName(final String str) {
        String spaceRemoved = str.replaceAll("\\s+", "");
        validateDelimiters(spaceRemoved);
        Set<String> names = Arrays.stream(spaceRemoved.split(NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toSet());

        names.forEach(StringParser::validateName);

        return names;
    }

    public static int parseInt(final String str) {
        if (!isNumeric(str)) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야만 합니다.");
        }

        return Integer.parseInt(str);
    }

    public static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static void validateDelimiters(final String nonSpaceStr) {
        String regex = String.format("[^%s0-9a-zA-Z]+", Pattern.quote(NAME_DELIMITER));

        Matcher matcher = Pattern.compile(regex).matcher(nonSpaceStr);
        if (matcher.find()) {
            throw new IllegalArgumentException("허용되지 않는 구분자가 포함되어 있습니다." + matcher.group());
        }
    }

    private static void validateName(final String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있어서는 안됩니다.");
        }

        if (str.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }
}
