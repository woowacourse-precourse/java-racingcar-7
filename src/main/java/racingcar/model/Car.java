package racingcar.model;

import racingcar.model.generator.NumberGenerator;

public class Car {

    private final CarName carName;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.carName = new CarName(name);
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
        return carName.getName();
    }
}
