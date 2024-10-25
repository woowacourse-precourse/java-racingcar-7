package racingcar.domain;

import static racingcar.constans.exception.ErrorMessage.FORWARD_COUNT_MUST_BE_NUMERIC;

public class Forward {

    private final int forwardCount;

    private Forward(String forwardCount) {
        Validator.validator(forwardCount);
        this.forwardCount = parseToInt(forwardCount);
    }

    public static Forward from(String forwardCount) {
        return new Forward(forwardCount);
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
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException(FORWARD_COUNT_MUST_BE_NUMERIC.getMessage());
            }
        }

    }

}