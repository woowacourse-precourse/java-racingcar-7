package racingcar.domain;

import static racingcar.constants.exception.ErrorMessage.FORWARD_COUNT_MUST_BE_SINGLE_DIGIT;

public class ForwardCount {

    private final int forwardCount;

    private ForwardCount(String forwardCount) {
        Validator.validator(forwardCount);
        this.forwardCount = parseToInt(forwardCount);
    }

    public static ForwardCount from(String forwardCount) {
        return new ForwardCount(forwardCount);
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private int parseToInt(String forwardCount) {
        return Integer.parseInt(forwardCount);
    }

    private static class Validator {

        private static void validator(String forwardCount) {
            Validator.validateNumeric(forwardCount);
        }

        private static void validateNumeric(String number) {
            if (!number.matches("[0-9]")) {
                throw new IllegalArgumentException(FORWARD_COUNT_MUST_BE_SINGLE_DIGIT.getMessage());
            }
        }

    }

}