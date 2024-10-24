package model;

import java.util.Objects;

public class Car {
    private final Name name;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this.name = name;
    }

    public static Name from(String name) {
       return new Name(name);
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
