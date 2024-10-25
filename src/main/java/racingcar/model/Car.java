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

    public static Car of(String name) {
        return new Car(name);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
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
