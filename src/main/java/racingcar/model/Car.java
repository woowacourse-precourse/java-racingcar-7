package racingcar.model;

import racingcar.util.Validator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        // 이름 유효성 검증(5자 이하)
        Validator.carName(name);
        this.name = name;

        // 초기 위치
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 위치 전진하는 메서드
    public void moveForward() {
        position++;
    }
}
