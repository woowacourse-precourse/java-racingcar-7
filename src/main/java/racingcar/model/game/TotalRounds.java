package racingcar.model.game;

public class TotalRounds {

    private static final int MAX_TOTAL_ROUNDS = 10;
    private static final int MIN_TOTAL_ROUNDS = 1;
    private final int totalRounds;

    public TotalRounds(int totalRounds) {
        validateRoundsInRange(totalRounds);

        this.totalRounds = totalRounds;
    }

    private void validateRoundsInRange(int totalRounds) {
        if (totalRounds < MIN_TOTAL_ROUNDS) {
            throw new IllegalArgumentException("총 라운드 수는 2회 이상이어야 합니다.");
        }

        if (totalRounds > MAX_TOTAL_ROUNDS) {
            throw new IllegalArgumentException("총 라운드 수는 10회 이하여야 합니다.");
        }
    }

    public boolean hasMoreRoundsThan(int currentRound) {
        return totalRounds > currentRound;
    }
}
