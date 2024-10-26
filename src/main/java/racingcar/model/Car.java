package racingcar.model;

import static racingcar.constant.NumberType.NUMBER_THRESHOLD;
import static racingcar.constant.NumberType.START_LOCATION;

import racingcar.utils.Random;

public class Car {
    private final String name;
    private int location;

    private Car(String name) {
        this.name = name;
        location = START_LOCATION.getNumber();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    private void go() {
        this.location++;
    }

    public void startRace() {
        int randomNumber = Random.createRandomNumber();
        if (randomNumber >= NUMBER_THRESHOLD.getNumber()) {
            go();
        }
    }

}
