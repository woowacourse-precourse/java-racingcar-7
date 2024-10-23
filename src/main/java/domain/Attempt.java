package domain;

import validator.AttemptValidator;

public class Attempt {
    private final int attempt;

    public Attempt(String attempt) {
        AttemptValidator.isPositiveDigit(attempt);
        this.attempt = Integer.parseInt(attempt);
    }

    public int getAttempt() {
        return attempt;
    }
}
