package racingcar.utils;

import static racingcar.utils.Constant.EXEC_RESULT;

public class Output {

    private final StringBuilder value;

    public Output() {
        this.value = new StringBuilder(EXEC_RESULT);
    }

    public void append(String value) {
        this.value.append(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
