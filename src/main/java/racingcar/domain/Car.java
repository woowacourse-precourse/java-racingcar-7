package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
    private final String name;
    private int position; // 자동차의 현재 위치 저장

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        position++;
    }
}
