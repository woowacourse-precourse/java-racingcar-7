package racingcar.model;

import java.math.BigInteger;

public class Car {
    private final String name;
    private BigInteger position;

    public Car(String name) {
        this.name = name;
        this.position = BigInteger.valueOf(0);
    }

    public String getName() {
        return name;
    }

    public BigInteger getPosition() {
        return position;
    }

    public void moveForward() {
        position = position.add(BigInteger.ONE);
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (BigInteger i = BigInteger.ZERO; i.compareTo(position) < 0; i = i.add(BigInteger.ONE)) {
            System.out.print("-");
        }
        System.out.println();
    }
}
