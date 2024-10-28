package racingcar.domain;

import racingcar.constant.ExceptionMessage;

public class ProgressManagement {

    private final int maxTryCount;
    private int currentTryCount = 0;

    public ProgressManagement(int maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    public void incrementTryCount() {
        validateTryCount();
        currentTryCount++;
    }

    private void validateTryCount() {
        if (currentTryCount >= maxTryCount) {
            ExceptionMessage exceptionMessage = ExceptionMessage.OVER_MAX_TRY_COUNT;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public boolean isProgress() {
        return currentTryCount < maxTryCount;
    }
}
