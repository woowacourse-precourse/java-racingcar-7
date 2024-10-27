package racingcar.model;

import racingcar.config.GameConfig;
import racingcar.util.RandomNumberGenerator;

public class Car {

    private final String name;
    private final int forward;

    private Car(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public static Car of(String name, int forward) {
        return new Car(name, forward);
    }

    public static Car of(String name) {
        return of(name, 0);
    }

    public Car play() {
        int randomNumber = RandomNumberGenerator.generateNumber();
        if (isForward(randomNumber)) {
            return of(name, forward + 1);
        }
        return this;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber > GameConfig.POSSIBLE_FORWARD_NUMBER;
    }

}
