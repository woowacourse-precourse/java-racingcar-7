package racingcar.support.repeater;

import racingcar.exception.InvalidCountException;

public class StringRepeater {

    private final String value;

    public StringRepeater(final String value) {
        this.value = value;
    }

    public String repeat(long count) {
        validate(count);
        if (count == 1) {
            return value;
        }

        StringBuilder repeatedValue = new StringBuilder();
        for (long i = 0; i < count; i++) {
            repeatedValue.append(value);
        }
        return repeatedValue.toString();
    }

    private void validate(final long count) {
        if (count < 0) {
            throw new InvalidCountException("count는 음수일 수 없습니다.");
        }
    }
}
