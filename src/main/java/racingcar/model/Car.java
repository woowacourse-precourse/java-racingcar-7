package racingcar.model;

import racingcar.utils.randomnumbergenerator.RandomNumberGenerator;

public class Car {
    String name;
    int distance;
    RandomNumberGenerator randomNumberGenerator;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        int randomNumber = randomNumberGenerator.getRandomNumber();
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


}
