package racingcar.domain;

public class ProgressManagement {

    private final int maxTryCount;
    private int currentTryCount;

    public ProgressManagement(int maxTryCount) {
        this.maxTryCount = maxTryCount;
        this.currentTryCount = 0;
    }

    public void incrementTryCount() {
        currentTryCount++;
    }

    public boolean isProgress() {
        return currentTryCount < maxTryCount;
    }
}
