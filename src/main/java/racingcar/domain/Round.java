package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int MIN_ROUND_VALUE = 1;
    private static final int FINAL_ROUND_NUMBER = 0;
    private static final int NEXT_ROUND_NUMBER = 1;
    private static final String MIN_VALUE_ERROR_MESSAGE = "시도 횟수는 " + MIN_ROUND_VALUE + "이상이어야 합니다.";

    private final int round;

    private Round() {
        this.round = FINAL_ROUND_NUMBER;
    }

    public Round(int round) {
        validateMinNumber(round);
        this.round = round;
    }

    private static void validateMinNumber(int round) {
        if (round < MIN_ROUND_VALUE) {
            throw new IllegalArgumentException(MIN_VALUE_ERROR_MESSAGE);
        }
    }

    public Round nextRound() {
        if (round == MIN_ROUND_VALUE) {
            return new Round();
        }
        return new Round(round - NEXT_ROUND_NUMBER);
    }

    public boolean isEnd() {
        return round == FINAL_ROUND_NUMBER;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Round round1 = (Round) object;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(round);
    }
}
