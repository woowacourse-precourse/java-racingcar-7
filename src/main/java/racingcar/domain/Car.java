package racingcar.domain;

import java.util.Objects;
import racingcar.domain.validation.CarValidator;

public class Car implements Comparable<Car> {

    private static final CarValidator validator = new CarValidator();
    private static final int MOVABLE_MARGIN = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        validator.validateEmpty(name);
        validator.validateMaximumLength(name);
        validator.validateWhiteSpace(name);
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVABLE_MARGIN) {
            distance += 1;
        }
    }

    public boolean matches(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car car) {
        return car.distance - distance;
    }
}
