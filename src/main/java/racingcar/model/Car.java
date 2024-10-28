package racingcar.model;

import java.math.BigInteger;

public class Car {
    private String name;
    private BigInteger move;

    public Car(String name, BigInteger move) {
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMove() {
        return move;
    }

    public void setMove(BigInteger move) {
        this.move = move;
    }
}
