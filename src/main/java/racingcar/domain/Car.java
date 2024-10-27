package racingcar.domain;

import racingcar.util.RandomGenerator;

public class Car {

    private static final int MOVE_FORWARD_STANDARD = 4;

    private final Name name;
    private int position;

    public Car(String carName) {
        name = new Name(carName);
        position = 0;
    }

    public void moveForward(RandomGenerator randomGenerator) {
        if (randomGenerator.generate() >= MOVE_FORWARD_STANDARD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", name, "-".repeat(position));
    }
}
