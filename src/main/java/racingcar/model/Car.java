package racingcar.model;

import racingcar.validator.CarNameValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        CarNameValidator.validate(name); // 이름 검증
        this.name = name;
        this.position = 0;
    }

    public void move(int distance) {
        position += distance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
