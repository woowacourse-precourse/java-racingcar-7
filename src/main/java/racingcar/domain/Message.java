package racingcar.domain;

import static racingcar.utils.Constant.WINNER_RESULT;

import java.util.Objects;
import racingcar.viewer.Output;

public class Message extends Output {

    private final String value;

    private Message(String value) {
        this.value = value;
    }

    public static Message createWinner(String result) {
        return new Message(WINNER_RESULT + result);
    }

    public static Message statusAll(CarList carList) {
        String statusAll = carList.statusAll();

        return new Message(statusAll);
    }

    public static Message result(Winners winners) {
        String result = winners.result();

        return createWinner(result);
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
