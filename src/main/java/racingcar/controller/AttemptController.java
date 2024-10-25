package racingcar.controller;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import racingcar.validation.ValidateAttempt;

public class AttemptController {

    public static int getAttempt(String inputAttempt) {
        ValidateAttempt.isInteger(inputAttempt);
        int attempt = Integer.parseInt(inputAttempt);
        ValidateAttempt.isOverZero(attempt);
        return attempt;
    }

}
