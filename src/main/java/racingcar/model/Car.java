package racingcar.model;

import java.util.Objects;

public class Car {

    private static final String BLANK_NAME_ERROR_MESSAGE = "공백은 이름이 될 수 없습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVEABLE_LIMIT = 4;
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
        location = 0;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR_MESSAGE);
        }
        if (isTooLong(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isTooLong(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }

    public void moveIfPossible(int number) {
        if (isMoveable(number)) {
            location++;
        }
    }

    private boolean isMoveable(int number) {
        return number >= MOVEABLE_LIMIT;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
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
}
