package racingcar.util;

import java.util.List;

public class Joiner {

    private final String delimiter;
    private static final String BLANK = " ";

    public Joiner(String delimiter) {
        this.delimiter = delimiter + BLANK;
    }

    public String join(List<String> strings) {
        return String.join(delimiter, strings);
    }

}
