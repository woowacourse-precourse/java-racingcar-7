package racingcar.model.race;

public class CarRaceRoundManager {

    private final int totalRoundCount;
    private int currentRoundCount = 0;

    public CarRaceRoundManager(int totalRoundCount) {
        if (totalRoundCount < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 해요.");
        }
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
