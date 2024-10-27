package racingcar.util.validator;

public class TrialsCountValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
    }
}
