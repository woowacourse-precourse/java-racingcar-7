package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int moveDistance;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        moveDistance = 0;
    }

    private void validateName(final String name) {
        validateNameLength(name);
        validateNameIsNotEmpty(name);
    }

    private void validateNameIsNotEmpty(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void moveIfPossible(final boolean canMove) {
        if (canMove) {
            moveDistance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
