package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public boolean hasHigherPositionThan(Car another) {
        return this.position >= another.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}
