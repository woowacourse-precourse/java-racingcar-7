package racingcar.game.model;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름의 길이는 5를 넘을 수 없습니다.";
    private final String name;

    private Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }
}