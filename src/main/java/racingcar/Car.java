package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int position;
    private static final Random random = new Random();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (random.nextInt(10) >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + ": " + "-".repeat(position);
    }
}
