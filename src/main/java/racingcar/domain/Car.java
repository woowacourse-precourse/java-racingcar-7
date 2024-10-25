package racingcar.domain;

import racingcar.utils.MovingUtils;
import java.math.BigInteger;

public class Car {

    private final Name name;
    private final Position position;

    private Car(String name) {
        this.name = Name.from(name);
        this.position = Position.from();
    }

    public String getName() {
        return name.getName();
    }

    public BigInteger getPosition() {
        return BigInteger.valueOf(position.positionDistance());
    }

    public String currentPositionFormat() {
        return name.getName() + " : " + position.getPosition();
    }

    public void move() {
        if (MovingUtils.isMovable()) {
            position.forward();
        }
    }

    public static Car from(Name name) {
        return new Car(name.getName());
    }
}
