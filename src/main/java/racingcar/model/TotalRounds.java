package racingcar.model;

public class TotalRounds {
    private final int totalRounds;

    public TotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }

    public boolean hasMoreRoundsThan(int currentRound) {
        return totalRounds >= currentRound;
    }
}
