package racingcar.model.game;

public class TotalRounds {

    private static final int MAX_TOTAL_ROUNDS = 10;
    private final int totalRounds;

    public TotalRounds(int totalRounds) {
        validate(totalRounds);

        this.totalRounds = totalRounds;
    }

    private void validate(int totalRounds) {
        if (totalRounds > MAX_TOTAL_ROUNDS) {
            throw new IllegalArgumentException("총 라운드 수는 10회 이하여야 합니다.");
        }
    }

    public boolean hasMoreRoundsThan(int currentRound) {
        return totalRounds >= currentRound;
    }
}
