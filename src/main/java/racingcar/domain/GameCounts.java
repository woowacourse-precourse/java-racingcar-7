package racingcar.domain;

public class GameCounts {

    private static final Integer SMALLEST_COUNT=1;
    private static final Integer BIGGEST_COUNT=Integer.MAX_VALUE;

    private static final String UNDER_SMALLEST_COUNT="게임은 한 번 이상 실행되어야 합니다";
    private static final String OVER_BIGGEST_COUNT="게임은 양수인 정수 범위에서 실행되어야 합니다";

    int gameCounts;

    public GameCounts(int gameCounts){
        validateMoreThanZero(gameCounts);
        this.gameCounts=gameCounts;
    }

    private void validateMoreThanZero(int gameCounts) {
        if (gameCounts<SMALLEST_COUNT){
            throw new IllegalArgumentException(UNDER_SMALLEST_COUNT);
        }
    }


}
