package racingcar.view.validator.lap;

import static java.util.Objects.isNull;

import racingcar.view.exception.EmptyInputException;

public class LapCountNullValidator extends LapCountInputValidator {

    private LapCountNullValidator() {
    }

    public static LapCountNullValidator initiate() {
        return new LapCountNullValidator();
    }

    @Override
    public void check(final String source) {
        if (isNull(source) || source.isEmpty() || source.isBlank()) {
            throw new EmptyInputException();
        }

        super.check(source);
    }
}
