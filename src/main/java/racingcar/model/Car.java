package racingcar.model;

import racingcar.util.ErrorMessages;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME.getMessage());
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public String getStatus() {
        return name + " : " + "-".repeat(position);
    }

    // 위치를 반환
    public int getPosition() {
        return position;
    }

    // 이름을 반환
    public String getName() {
        return name;
    }
}
