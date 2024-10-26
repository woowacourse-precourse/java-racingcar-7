package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다: " + name);
        }
    }

    public void move() {
        int randomValue = RandomNumberGenerator.generate(0, 9);
        if (randomValue >= 4) {
            position++;
        }

    }
}
