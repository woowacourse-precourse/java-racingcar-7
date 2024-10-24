package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_CAR_NAME_SIZE = 5;

    private final String name;
    private final int position;

    private Car(String name) {
        validateCar(name);

        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCar(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
