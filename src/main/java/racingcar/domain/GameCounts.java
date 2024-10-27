package racingcar.domain;

public class GameCounts {
    private static final Integer SMALLEST_COUNT = 1;
    private static final String UNDER_SMALLEST_COUNT = "게임은 한 번 이상 실행되어야 합니다";
    private static final String OVER_BIGGEST_COUNT = "게임은 양수인 정수 범위에서 실행되어야 합니다";
    private final int gameCounts;

    public int getGameCounts() {
        return gameCounts;
    }

    public GameCounts(String gameCounts) {
        validateIntegerRange(gameCounts);
        validateMoreThanZero(gameCounts);
        this.gameCounts = Integer.parseInt(gameCounts);
    }

    private void validateIntegerRange(String gameCounts) {
        try {
            Integer.parseInt(gameCounts);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OVER_BIGGEST_COUNT);
        }
    }

    private void validateMoreThanZero(String gameCounts) {
        int countsToNum = Integer.parseInt(gameCounts);

        if (countsToNum < SMALLEST_COUNT) {
            throw new IllegalArgumentException(UNDER_SMALLEST_COUNT);
        }
    }

}
