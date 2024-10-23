package racingcar.global.error;

public class TryCountError extends IllegalArgumentException {

    private Error error;

    public TryCountError(Error error) {
        super(error.getErrorMsg());
    }
}