package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car {
    private final NumberGenerator numberGenerator;
    private final String name;
    private int position;

    public Car(String name, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }

    public Car(String name) {
        this.numberGenerator = new RandomNumberGenerator();
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (numberGenerator.getNumber() >= 4)
            position++;
    }

}
