package model;

import strategy.Strategy;

import java.util.Objects;

public class Car {
    private static final int FRONT_MOVE_NUMBER = 4;
    private final Name name;
    private int moveCount;


    public Car(String name) {
        this(new Name(name), 0);
    }

    public Car(Name name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void move(Strategy strategy) {
        if(strategy.move() >= FRONT_MOVE_NUMBER) {
            moveCount++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
