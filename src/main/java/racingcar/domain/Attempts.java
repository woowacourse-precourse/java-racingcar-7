package racingcar.domain;

import racingcar.utils.validation.AttemptValidation;

import java.math.BigInteger;

public class Attempts {

    private BigInteger attempt;

    public Attempts(String attempt) {
        AttemptValidation.validate(attempt);
        this.attempt = new BigInteger(attempt);
    }

    public void decrease() {
        attempt = attempt.subtract(BigInteger.ONE);
    }

    public boolean isLeft() {
        return !(attempt.compareTo(BigInteger.ZERO) == 0);
    }

    public static Attempts from(String attempt) {
        return new Attempts(attempt);
    }
}
