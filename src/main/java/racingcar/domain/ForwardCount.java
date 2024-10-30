package racingcar.domain;

import static racingcar.constants.exception.ErrorMessage.FORWARD_COUNT_MUST_BE_IN_RANGE;

public class ForwardCount {

    private static final String FORWARD_COUNT_REGEX = "^(100|[1-9][0-9]?)$";

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
            if (!number.matches(FORWARD_COUNT_REGEX)) {
                throw new IllegalArgumentException(FORWARD_COUNT_MUST_BE_IN_RANGE.getMessage());
            }
        }

    }

}