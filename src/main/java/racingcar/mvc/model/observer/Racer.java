package racingcar.mvc.model.observer;

import java.math.BigInteger;

public abstract class Racer implements Observer {
    protected static final String UNIT_OF_DISTANCE = "-";
    protected String name;
    protected BigInteger distance = BigInteger.ZERO;

    public Racer(String name) {
        this.name = name;
    }

    public BigInteger getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract void update();

    @Override
    public abstract String toString();
}
