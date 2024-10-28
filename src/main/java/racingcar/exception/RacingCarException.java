package racingcar.exception;

public abstract class RacingCarException extends IllegalArgumentException {
    /**
     * Constructs an {@code IllegalArgumentException} with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public RacingCarException(String s) {
        super(s);
    }
}
