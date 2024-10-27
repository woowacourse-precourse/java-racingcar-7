package racingcar.domain.car;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private CarName(final String name) {
        validateCarName(name);
        this.name = name.trim();
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validateCarName(final String name) {
        validateIsBlank(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 최대 5자까지 가능합니다");
        }
    }

    private void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백을 이름으로 사용할 수 없습니다");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
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
        return Objects.hashCode(name);
    }
}
