package racingcar.domain;

import racingcar.util.ErrorMessage;

public class Car {
    // 이름, 위치
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LESS_THAN_FIVE.getMessage());
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NOT_BLANK_OR_EMPTY.getMessage());
        }

        this.name = name;
    }

    public void movePosition() {
        position += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
