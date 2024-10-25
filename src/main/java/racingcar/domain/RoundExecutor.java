package racingcar.domain;

public class RoundExecutor {
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 100;
    private static final String ROUND_LENGTH_ERROR_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하여야 합니다.", MIN_ROUND, MAX_ROUND);

    private int round;

    public RoundExecutor(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int raceRound) {
        if (raceRound < MIN_ROUND || raceRound > MAX_ROUND) {
            throw new IllegalArgumentException(ROUND_LENGTH_ERROR_MESSAGE);
        }
    }

    public void executeAllRound(Runnable runnable) {
        while (round-- >= MIN_ROUND) {
            runnable.run();
        }
    }
}
