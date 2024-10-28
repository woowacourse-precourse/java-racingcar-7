package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private final String name;
    private Integer position;

    public void move() {
        if (pickNumberInRange(0,9) >= 4) {
            position++;
        }
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

}
