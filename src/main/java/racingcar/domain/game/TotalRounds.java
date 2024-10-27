package racingcar.domain.game;

import static racingcar.constant.GameConstants.MAXIMUM_ROUNDS;
import static racingcar.constant.GameConstants.MINIMUM_ROUNDS;

import racingcar.exception.game.InvalidRoundsException.InvalidTotalRoundsException;

public class TotalRounds {
    private final int value;

    private TotalRounds(int value) {
        validate(value);
        this.value = value;
    }

    public static TotalRounds of(int value) {
        return new TotalRounds(value);
    }

    private void validate(int rounds) {
        if (rounds < MINIMUM_ROUNDS || rounds > MAXIMUM_ROUNDS) {
            throw new InvalidTotalRoundsException();
        }
    }
}
