package racingcar.app.front.validator.lap;

import static racingcar.app.front.preprocessor.input.LapCountPreprocessor.replaceAllUnNecessaryChar;

import racingcar.app.front.exception.LoeZeroException;

public class NumberFormatValidator extends LapCountInputValidator {

    private NumberFormatValidator() {
    }

    public static NumberFormatValidator initiate() {
        return new NumberFormatValidator();
    }

    @Override
    public void check(final String source) {
        String cleanSource = replaceAllUnNecessaryChar(source);

        long count = Long.parseLong(cleanSource);
        if (count <= 0) {
            throw new LoeZeroException();
        }

        super.check(source);
    }
}
