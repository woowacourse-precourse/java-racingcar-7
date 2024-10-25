package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Validator;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validate(name);
        this.name = name;
    }


    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random > 4) {
            distance++;
        }
    }

    private void validate(String name) {
        Validator.isEmpty(name);
        Validator.isCarNameRange(name);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
