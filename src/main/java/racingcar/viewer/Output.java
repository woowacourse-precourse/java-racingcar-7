package racingcar.viewer;

import static racingcar.utils.Constant.EXEC_RESULT;

import racingcar.domain.Message;

public class Output {

    private final StringBuilder value;

    public Output() {
        this.value = new StringBuilder(EXEC_RESULT);
    }

    public void append(Message message) {
        String value = message.toString();

        this.value.append(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
