package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        validateNameIsBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position++;
        }
    }

    private void validateNameIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
