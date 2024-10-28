package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.strategy.Strategy;

public class Car implements Vehicle {

    private static final int MIN_MOVABLE_NUMBER = 4;

    private final Name name;
    private final Position position;
    private final Strategy strategy;

    private Car(Name name, Position position, Strategy strategy) {
        this.name = name;
        this.position = position;
        this.strategy = strategy;
    }

    public static Car of(Name name, Position position, Strategy strategy) {
        return new Car(name, position, strategy);
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public boolean canMoveForwardRandomly() {
        if (strategy.generate() >= MIN_MOVABLE_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public Vehicle moveForwardRandomly() {
        if (canMoveForwardRandomly()) {
            int value = position.getValue();
            return Car.of(name, Position.from(++value), strategy);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName())
                && Objects.equals(getPosition(), car.getPosition())
                && Objects.equals(getStrategy(), car.getStrategy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getStrategy());
    }
}

