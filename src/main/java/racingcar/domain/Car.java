package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int MOVING_STANDARD = 4;
    private static final int NAME_LENGTH_BOUND = 5;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 1~5글자 사이여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int movingNumber) {
        if (movingNumber >= MOVING_STANDARD) {
            position++;
        }
    }
}
