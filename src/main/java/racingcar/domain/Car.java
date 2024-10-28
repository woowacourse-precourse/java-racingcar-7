package racingcar.domain;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car implements Vehicle {
    private final String name;
    private int location;

    @Override
    public void move() {
        if (pickNumberInRange(0, 9) >= 4) {
            moveLocation();
        }
    }

    private void moveLocation() {
        location++;
    }

    public void printLocation() {
        String sb = this.getName()
                        + " : "
                        + "-"
                        .repeat(Math.max(0, location));
        System.out.println(sb);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getLocation() == car.getLocation() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
