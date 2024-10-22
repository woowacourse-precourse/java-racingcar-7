package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private static final String NAME_LENGTH_ERROR = "자동차의 이름의 길이는 1 이상 " + MAX_LENGTH + "이하이어야 합니다.";
    private static final String BLANK_CONTAIN_ERROR_MESSAGE = "자동차 이름에 공백은 포함될 수 없습니다.";

    private final String name;
    private int position = DEFAULT_POSITION;

    public Car(String name) {
        validateNameLength(name);
        validateContainBlank(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_CONTAIN_ERROR_MESSAGE);
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
