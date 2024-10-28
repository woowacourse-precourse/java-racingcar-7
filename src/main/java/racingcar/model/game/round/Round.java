package racingcar.model.game.round;

import java.util.Objects;
import racingcar.exception.InvalidRoundException;

public class Round {

    private final long round;

    public Round(final String input) {
        validateInput(input);
        try {
            long round = Long.parseLong(input);
            validateValue(round);
            this.round = round;
        } catch (NumberFormatException e) {
            throw new InvalidRoundException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    private void validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidRoundException("라운드 횟수는 null이거나 공백일 수 없습니다.");
        }
    }

    private void validateValue(final long round) {
        if (round < 0) {
            throw new InvalidRoundException("시도할 횟수는 0 또는 양수여야 합니다.");
        }
    }

    public long round() {
        return round;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round other = (Round) o;
        return round == other.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
