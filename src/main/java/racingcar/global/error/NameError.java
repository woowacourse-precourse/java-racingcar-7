package racingcar.global.error;

public class NameError extends IllegalArgumentException {

    private Error error;

    public NameError(Error error) {
        super(error.getErrorMsg());
    }
}