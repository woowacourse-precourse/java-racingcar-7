package racingcar.error;

public class InputException extends IllegalArgumentException {
    private final InputErrorType inputError;

    public InputException(InputErrorType inputError) {
        this.inputError = inputError;
    }

    @Override
    public String getMessage() {
        return inputError.getMessage();
    }
}