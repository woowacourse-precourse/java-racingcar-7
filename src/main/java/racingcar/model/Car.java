package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder position;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public void moveIfAboveThreshold(int randomNumber) {
        if (randomNumber >= 4)
            position.append('-');
    }

    public String getPosition() {
        return position.toString();
    }

    public String getName() {
        return name;
    }
}
