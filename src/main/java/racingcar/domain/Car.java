package racingcar.domain;

import racingcar.utils.MovingUtils;
import racingcar.utils.validation.CarNameValidation;

import java.math.BigInteger;

public class Car {

    private final Name name;
    private final Position position;

    private Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return name.getName();
    }

    public BigInteger getPosition() {
        return BigInteger.valueOf(position.positionDistance());
    }

    public String currentPositionFormat() {
        return name + " : " + position;
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
