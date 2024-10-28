package racingcar.model;

import java.math.BigInteger;

public class Lap {

    private static final BigInteger MIN_INT_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger MAX_INT_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);

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
            final BigInteger attempts = new BigInteger(numberOfAttempts);
            if (attempts.compareTo(MIN_INT_VALUE) < 0 || attempts.compareTo(MAX_INT_VALUE) > 0) {
                throw new IllegalArgumentException("시도 횟수가 int 범위를 벗어났습니다.");
            }
            return attempts.intValue();
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
