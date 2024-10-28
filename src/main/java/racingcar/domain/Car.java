package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int RANDOM_NUMBER_STANDARD = 4;

    private final CarName name;
    private int position;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        final int generatedRandomNumber = RandomNumberGenerator.generateRandomNumber();
        if(generatedRandomNumber >= RANDOM_NUMBER_STANDARD) {
            this.position++;
        }
    }

    public CarName getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
