package racingcar.car;

import java.math.BigInteger;

public class Car {

    private final String name;
    private String position = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPosition() {
        return BigInteger.valueOf(position.length());
    }

    public String currentPositionFormat() {
        return name + " : " + position;
    }

    public void moveOrStop(boolean isMoveable) {
        if (isMoveable) {
            position += "-";
        }
    }
}
