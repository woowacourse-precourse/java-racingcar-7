package racingcar.infrastructure.constant;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum CarNameDelimiter {
    COMMA(",");

    private final String delimiter;

    private CarNameDelimiter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public String getValue() {
        return delimiter;
    }

    public static String getRegex() {
        List<String> delimiters = Arrays.stream(CarNameDelimiter.values())
                .map(c -> Pattern.quote(c.getValue()))
                .toList();
        return String.join("|", delimiters);
    }
}
