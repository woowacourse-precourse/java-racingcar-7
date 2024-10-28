package racingcar.validator;

public class AttemptCountValidator implements Validator {

    private static final String ERROR_NOT_NON_NEGATIVE_INTEGER = "Input a non-negative integer.";

    @Override
    public void validate(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_NOT_NON_NEGATIVE_INTEGER);
        }
    }
}
