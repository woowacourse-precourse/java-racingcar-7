package racingcar.domain;

import java.util.Objects;

public class Car implements Vehicle{
    private final String name;
    private int forward = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    @Override
    public void move(){
        forward++;
    }

    public String print() {
        StringBuilder currentCar = new StringBuilder();
        currentCar.append(name);
        currentCar.append(" : ");
        currentCar.append("-".repeat(forward));
        return currentCar.toString();
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
        return Objects.hashCode(name);
    }
}
