package racingcar.domain;

public class RacingGameRound {

    private final Integer round;

    public RacingGameRound(final Integer round) {
        validate(round);

        this.round = round;
    }

    public Integer getRound() {
        return round;
    }

    private void validate(final Integer round) {
        if (round == null || round <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
