package racingcar;

public class RaceReferee {

    private static final int MOVE_RULE = 4;
    private final int round;

    private RaceReferee(int round) {
        this.round = round;
    }

    public static RaceReferee from(int round) {
        validateRound(round);
        return new RaceReferee(round);
    }

    private static void validateRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("경주 횟수는 음수일 수 없습니다.");
        }
    }
}
