package racingcar.car;

import racingcar.util.RandomNumberGenerator;

public class Car {

    public static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = RandomNumberGenerator.generateRandomNumber();
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameRange(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }
}
