package racingcar.message;

public interface Message {

    String getMessage();

    default String getFormatMessage(Object... args) {
        return String.format(getMessage(), args);
    }
}
