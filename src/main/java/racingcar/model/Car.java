package racingcar.model;

import racingcar.exception.ErrorMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5; // 자동차 이름의 최대 길이
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        checkForNullOrEmpty(name);
        checkNameLength(name);
    }

    private void checkForNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }
}