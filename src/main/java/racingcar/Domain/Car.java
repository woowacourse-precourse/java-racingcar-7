package racingcar.Domain;

import racingcar.Dto.CarData;

import java.util.Random;

public class Car {
    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    private void validNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯자 이내로 입력하세요");
        }
    }

    public void move() {
        movedDistance++;
    }

    public CarData getCurrentCarData() {
        return new CarData(name, movedDistance);
    }
}
