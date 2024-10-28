package racingcar.domain.racing;

import java.util.Objects;

public class Round {

    private static final int MIN_ROUND_TOTAL = 1;
    private static final int MAX_ROUND_TOTAL = 100;

    private final int total;

    private Round(final int total) {
        validateRange(total);
        this.total = total;
    }

    public static Round create(final int total) {
        return new Round(total);
    }

    private void validateRange(final int total) {
        if (total < MIN_ROUND_TOTAL || total > MAX_ROUND_TOTAL) {
            throw new IllegalArgumentException(String.format(
                    "자동차 경주는 %d 이상 %d 이하의 라운드만 진행 가능합니다.", MIN_ROUND_TOTAL, MAX_ROUND_TOTAL
            ));
        }
    }

    public int total() {
        return total;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Round round)) {
            return false;
        }
        return total == round.total;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(total);
    }

    @Override
    public String toString() {
        return "Round{" +
                "total=" + total +
                '}';
    }

}
