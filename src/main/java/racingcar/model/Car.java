package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Validator;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
    }

    public static Car of(String name){
        return new Car(name);
    }

    public void move() {
        if (makeRandomNumber() >= 4) {
            distance++;
        }
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
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
