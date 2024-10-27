package racingcar.model.race;

public class CarRaceRoundManager {

    private final int totalRoundCount;
    private int currentRoundCount = 0;

    public CarRaceRoundManager(int totalRoundCount) {
        this.totalRoundCount = totalRoundCount;
    }

    public boolean hasMoreRounds() {
        return currentRoundCount < totalRoundCount;
    }

    public void nextRound() {
        if (!hasMoreRounds()) {
            throw new IllegalStateException("더 이상 진행할 라운드가 없습니다. (종료된 경기입니다.)");
        }
        currentRoundCount++;
    }
}
