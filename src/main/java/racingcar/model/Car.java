package racingcar.model;

import racingcar.model.generator.NumberGenerator;

public class Car {

    private final String name;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name).getName();
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        if (numberGenerator.generateNum() >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
