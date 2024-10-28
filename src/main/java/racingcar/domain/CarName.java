package racingcar.domain;

import java.util.Objects;

class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    private CarName(final String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    static CarName of(final String carName) {
        validate(carName);
        return new CarName(carName.trim());
    }

    private static void validate(final String carName) {
        validateSpace(carName);
        validateLength(carName);
    }

    private static void validateSpace(final String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
        }
    }

    private static void validateLength(final String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MAX_LENGTH + " 이하여야 합니다");
        }
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

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
