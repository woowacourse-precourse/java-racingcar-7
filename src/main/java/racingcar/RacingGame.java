package racingcar;

public class RacingGame {
    private int MINIMUM_ROUND = 1;

    private final int round;

    public RacingGame(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (MINIMUM_ROUND > round) {
            throw new IllegalArgumentException("경주에 참여하려면 최소 1라운드 이상 설정해야 해요.");
        }

    }
}
