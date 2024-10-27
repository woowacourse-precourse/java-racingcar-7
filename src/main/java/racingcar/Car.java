package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) { // 이름은 5자 이하로 제한되며, 이를 초과할 경우 예외가 발생
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getProgress() {
        return "-".repeat(position); // 현재 위치를 표현
    }
}
