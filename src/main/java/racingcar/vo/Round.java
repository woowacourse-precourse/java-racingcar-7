package racingcar.vo;

import static racingcar.constant.ExceptionMessage.INVALID_ROUND_MIN;

import java.util.Objects;

public class Round {
    private static final int MINIMUM_ROUND = 0;

    private final int value;

    private Round(int value) {
        validateMinimum(value);
        this.value = value;
    }

    public static Round from(int value) {
        return new Round(value);
    }

    private void validateMinimum(int value) {
        if (value < MINIMUM_ROUND) {
            throw new IllegalArgumentException(INVALID_ROUND_MIN.format(MINIMUM_ROUND));
        }
    }

    public Round next() {
        return new Round(value + 1);
    }

    public int getCount() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Round other)) {
            return false;
        }
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
