package racingcar.domain;

import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.Objects;
import racingcar.viewer.Output;

public class Message extends Output {

    private final String value;

    private Message(String value) {
        this.value = value;
    }

    public static Message create(String value) {
        return new Message(value);
    }

    public static Message createWinner(String value) {
        return new Message(WINNER_RESULT + value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(value, message.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
