package racingcar.domain;

public class GameStatistics {
    private final int totalRounds;
    private final double averageForwardRate;
    private final int maxConsecutiveForwards;

    public GameStatistics(int totalRounds, double averageForwardRate, int maxConsecutiveForwards) {
        this.totalRounds = totalRounds;
        this.averageForwardRate = averageForwardRate;
        this.maxConsecutiveForwards = maxConsecutiveForwards;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public double getAverageForwardRate() {
        return averageForwardRate;
    }

    public int getMaxConsecutiveForwards() {
        return maxConsecutiveForwards;
    }
}