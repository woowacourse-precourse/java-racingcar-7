package racingcar;

public class Race {
    private final int totalGameTurn;

    public Race(int totalGameTurn) {
        if (totalGameTurn <= 0) {
            throw new IllegalArgumentException("총 게임 횟수는 1회 이상이어야 합니다.");
        }
        this.totalGameTurn = totalGameTurn;
    }


}
