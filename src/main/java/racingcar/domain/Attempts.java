package racingcar.domain;

import racingcar.utils.validation.AttemptValidation;

import java.math.BigInteger;

public class Attempts {

    private int attempt;

    private Attempts(String attempt) {
        AttemptValidation.validate(attempt);
        this.attempt = Integer.parseInt(attempt);
    }

    public void decrease() {
        attempt -= 1;
    }

    public boolean isLeft() {
        return !(attempt == 0);
    }

    public static Attempts from(String attempt) {
        return new Attempts(attempt);
    }
}
