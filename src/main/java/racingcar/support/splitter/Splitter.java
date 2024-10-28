package racingcar.support.splitter;

import racingcar.exception.InvalidDelimiterException;

public class Splitter {

    private final String delimiter;

    public Splitter(final String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidDelimiterException("구분자는 null이거나 빈 값일 수 없습니다.");
        }
    }

    public String[] splitFrom(final String inputNames) {
        return inputNames.split(delimiter, -1);
    }
}
