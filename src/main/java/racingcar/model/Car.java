package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private final String name;
    private int position = 0;

    private Car(final String name) {
        this.name = name;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move() {
        if(RandomUtil.generateRandomNumber() >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
