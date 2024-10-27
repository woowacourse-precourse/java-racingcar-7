package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;

    public CarName(final String value) {
        validateBlank(value);
        validateLength(value);
        this.name = value;
    }

    private void validateLength(final String value) {
        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
        }
    }

    private void validateBlank(final String value) {
        if (value == null) {
            throw new NullPointerException("자동차 이름에 null이 올 수 없습니다.");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public String getCarName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
