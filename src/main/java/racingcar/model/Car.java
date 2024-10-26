package racingcar.model;

import java.util.Objects;

public class Car {

    private static final String ERROR_EMPTY_NAME_MESSAGE = "자동차 이름이 공백으로 입력되었습니다.";
    private static final String ERROR_NAME_LENGTH_MESSAGE = "자동차 이름 입력 길이를 초과하였습니다. (최대 5자)";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_THRESHOLD = 4;

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        validateName();
    }

    private void validateName() {
        if (this.name.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME_MESSAGE);
        }
        if (this.name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void moveFront(int randomNumber) {
        if (randomNumber < MOVE_FORWARD_THRESHOLD) {
            return;
        }
        position++;
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
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
