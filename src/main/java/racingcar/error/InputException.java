package racingcar.error;

public class InputException extends IllegalArgumentException {
    private final InputError inputError;

    public InputException(InputError inputError) {
        this.inputError = inputError;
    }

    @Override
    public String getMessage() {
        return inputError.getMessage();
    }
}