package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.NumberConstant.*;
import static racingcar.exception.ExceptionMessage.*;


public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = 0;
    }

    private void validName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_REQUIRED);
        }

        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT);
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_VALIDATION);
        }
    }

    public void moveForwardIfDigitAboveThreshold(int digit) {
        if (digit < MOVE_THRESHOLD) {
            return;
        }
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}