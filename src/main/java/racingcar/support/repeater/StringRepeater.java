package racingcar.support.repeater;

import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidValueException;

public class StringRepeater {

    private final String value;

    public StringRepeater(final String value) {
        validateValue(value);
        this.value = value;
    }

    public String repeat(long count) {
        validateCount(count);
        if (count == 1) {
            return value;
        }

        StringBuilder repeatedValue = new StringBuilder();
        for (long i = 0; i < count; i++) {
            repeatedValue.append(value);
        }
        return repeatedValue.toString();
    }

    private void validateValue(final String value) {
        if (value == null || value.isEmpty()) {
            throw new InvalidValueException("반복할 문자열은 null이거나 빈 값일 수 없습니다.");
        }
    }

    private void validateCount(final long count) {
        if (count < 0) {
            throw new InvalidCountException("count는 음수일 수 없습니다.");
        }
    }
}
