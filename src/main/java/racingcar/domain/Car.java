package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final String EMPTY_CAR_NAME_ERROR = "경주할 자동차 이름을 입력해주세요.";
    public static final String INVALID_CAR_NAME_LENGTH_ERROR = "경주할 자동차 이름은 5자 이하입니다.";
    public static final int STANDARD_VALUE_CAR_CAN_MOVE = 4;
    public static final int MAXIMUM_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    public void move(int condition) {
        if (condition >= STANDARD_VALUE_CAR_CAN_MOVE) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car winner) {
        return winner.position == this.position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR);
        }
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR);
        }
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
