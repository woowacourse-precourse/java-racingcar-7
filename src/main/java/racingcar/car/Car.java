package racingcar.car;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = RandomNumberGenerator.generateRandomNumber();
        if (number >= 4) {
            position++;
        }
    }

    private void validateNameRange(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }
}
