package racingcar.model;

import racingcar.utils.Random;

public class Car {

    private final String name;
    private int location;

    private Car(String name) {
        this.name = name;
        location = 0;
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
        if (randomNumber >= 4) {
            go();
        }
    }

}
