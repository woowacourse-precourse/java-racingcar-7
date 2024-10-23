package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int distance;

    protected Car(String name) {
        this.name = name;
        distance = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void moveCar(Integer randomNumber) {
        if(randomNumber >= 4) {
            distance++;
        }
    }

    public String getCarname() {
        return name;
    }

    public Integer getCarDistance() {
        return distance;
    }
}
