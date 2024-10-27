package racingcar.app.front.validator.lap;

import static java.math.BigInteger.ZERO;
import static racingcar.app.front.preprocessor.input.LapCountPreprocessor.replaceAllUnNecessaryChar;

import java.math.BigInteger;
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
        BigInteger count = new BigInteger(cleanSource);

        if (isLoeZero(count)) {
            throw new LoeZeroException();
        }

        super.check(source);
    }

    private boolean isLoeZero(BigInteger count) {
        return count.compareTo(ZERO) <= 0;
    }
}
