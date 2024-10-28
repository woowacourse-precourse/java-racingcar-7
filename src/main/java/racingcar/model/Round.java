package racingcar.model;

import java.util.Objects;

public class Round {
    private int round;

    private Round(int round) {
        validateRoundIsPositive(round);
        this.round = round;
    }

    public static Round of(int round) {
        return new Round(round);
    }

    private void validateRoundIsPositive(int round) {
        if (round < 1) {
            throw new IllegalArgumentException();
        }
    }

    public void proceed() {
        round--;
    }

    public boolean isZero() {
        return round == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Round round1)) return false;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(round);
    }
}
