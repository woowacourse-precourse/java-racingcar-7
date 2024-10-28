package racingcar.gameplayer.game.common.domain;

import java.util.Objects;

public class PositiveNumber {

    private final Long number;

    public PositiveNumber(int number) {
        Long longNumber = (long) number;
        valid(longNumber);
        this.number = longNumber;
    }

    public PositiveNumber(Long number) {
        valid(number);
        this.number = number;
    }

    public PositiveNumber(String number) {
        this(Long.parseLong(number));
    }

    private void valid(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("PositiveNumber는 음이 아닌 정수여야 합니다");
        }
    }

    public PositiveNumber add(PositiveNumber other) {
        return new PositiveNumber(number + other.number);
    }

    public boolean greaterThanOrEqualTo(PositiveNumber other) {
        return number >= other.number;
    }

    public Long getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
