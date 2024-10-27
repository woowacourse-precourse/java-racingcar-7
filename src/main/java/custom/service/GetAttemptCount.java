package custom.service;

import custom.validator.InputValidator;

public class GetAttemptCount {
    private final InputValidator inputValidator;

    public GetAttemptCount() {
        this.inputValidator = new InputValidator();
    }

    public int convertStringToNumber(String input) {
        return Integer.parseInt(input);
    }

    public int run(String input) {
        inputValidator.checkEmptyInput(input);
        inputValidator.validateAttemptCountIsNumeric(input);
        inputValidator.validateIntegerOverflow(input);

        int attemptCount = convertStringToNumber(input);

        inputValidator.validateAttemptCountRange(attemptCount);

        return attemptCount;
    }
}