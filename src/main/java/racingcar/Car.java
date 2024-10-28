package racingcar;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
