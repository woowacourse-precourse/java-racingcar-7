package racingcar.model;

public class Lap {

    private final int maxLaps;
    private int currentLap;

    public Lap(final String numberOfAttempts) {
        this.maxLaps = parseAndValidateAttempts(numberOfAttempts);
        this.currentLap = 0;
    }

    private int parseAndValidateAttempts(final String numberOfAttempts) {
        final int attempts = parseNumberOfAttempts(numberOfAttempts);
        validateSize(attempts);
        return attempts;
    }

    private int parseNumberOfAttempts(final String numberOfAttempts) {
        try {
            return Integer.parseInt(numberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.", e);
        }
    }

    private void validateSize(final int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
    }

    public boolean isRemaining() {
        return currentLap < maxLaps;
    }

    public void proceed() {
        currentLap += 1;
    }
}
