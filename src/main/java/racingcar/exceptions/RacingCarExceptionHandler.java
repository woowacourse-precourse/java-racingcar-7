package racingcar.exceptions;

public class RacingCarExceptionHandler {

    public static void throwException(RacingCarExceptionMessage message) {
        throw new IllegalArgumentException(message.getText());
    }
}