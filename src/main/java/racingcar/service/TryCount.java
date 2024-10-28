package racingcar.service;

import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount) {
        if(tryCount<0) {
            throw new IllegalArgumentException(ILLEGAL_TRY_COUNT.getMessage());
        }
    }

    public boolean playOneRound() {
        return tryCount-->0;
    }
}
