package model;

import java.util.Objects;

public class Car {
    private final Name name;
    private final int moveCount;


    public Car(String name) {
        this(new Name(name), 0);
    }

    public Car(Name name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
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
