package model;

import strategy.Strategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private final MoveNumber moveNumber;

    public Car(String name) {
        this(new Name(name), new MoveNumber(0));
    }

    public Car(Name name, MoveNumber moveNumber) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public void move(Strategy strategy) {
        this.moveNumber.move(strategy.random());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(moveNumber, car.moveNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveNumber);
    }

}
