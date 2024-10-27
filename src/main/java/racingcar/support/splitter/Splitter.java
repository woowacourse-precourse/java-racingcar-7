package racingcar.support.splitter;

public class Splitter {

    public static final int LIMIT = -1;

    private final String delimiter;

    public Splitter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] splitFrom(final String inputNames) {
        return inputNames.split(delimiter, LIMIT);
    }
}
