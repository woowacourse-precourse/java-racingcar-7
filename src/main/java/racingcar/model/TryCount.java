package racingcar.model;

import static racingcar.constants.ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK;
import static racingcar.constants.ErrorMessage.NOT_ALLOWED_UNDER_MINIMUM_TRY_COUNT;
import static racingcar.constants.ErrorMessage.TRY_COUNT_MUST_BE_NUMERIC;

public class TryCount {
    private static final int MINIMUM_TRY_COUNT = 1;
    private final String rawTryCount;

    public TryCount(String rawTryCount) {
        validate(rawTryCount);
        this.rawTryCount = rawTryCount;
    }

    private void validate(String rawTryCount) {
        validateStrip(rawTryCount);
        validateNumeric(rawTryCount);
        validateMinimum(rawTryCount);
    }

    private void validateStrip(String rawTryCount) {
        String stripped = rawTryCount.strip();
        if (!stripped.equals(rawTryCount)) {
            throw new IllegalArgumentException(NOT_ALLOWED_FIRST_LAST_BLANK);
        }
    }

    private void validateNumeric(String rawTryCount) {
        try {
            Integer.parseInt(rawTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_NUMERIC);
        }
    }

    private void validateMinimum(String rawTryCount) {
        int tryCount = Integer.parseInt(rawTryCount);
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(NOT_ALLOWED_UNDER_MINIMUM_TRY_COUNT);
        }
    }

    public int toInteger() {
        return Integer.parseInt(rawTryCount);
    }
}
