package racingcar;

import java.math.BigInteger;

public class Car {

    private final String name;
    private final BigInteger moveDistance = BigInteger.ONE;
    private BigInteger currentPosition = BigInteger.ZERO;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        currentPosition = currentPosition.add(moveDistance);
    }

    public BigInteger getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
