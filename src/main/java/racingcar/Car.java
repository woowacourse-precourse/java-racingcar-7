package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
