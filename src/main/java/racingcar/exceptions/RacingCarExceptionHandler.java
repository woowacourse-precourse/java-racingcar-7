package racingcar.exceptions;

public class RacingCarExceptionHandler {

    public static void getException(RacingCarExceptionMessage message) {
        throw new IllegalArgumentException(message.getText());
    }
}