package racingcar.support.splitter;

public class Splitter {

    private final String delimiter;

    public Splitter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] splitFrom(final String inputNames) {
        return inputNames.split(delimiter, -1);
    }
}
