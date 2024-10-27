package racingcar.controller;

import racingcar.validation.AttemptValidation;

public class AttemptController {

    public static int getAttempt(String inputAttempt) {
        AttemptValidation.isInteger(inputAttempt);
        int attempt = Integer.parseInt(inputAttempt);
        AttemptValidation.isOverZero(attempt);
        return attempt;
    }

}
