package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private final CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move() {
        if (canMove()) {
            distance++;
        }
    }

    public CarDetail getCarDetail() {
        return new CarDetail(name.getName(), distance);
    }

    private static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    @Override
    public int compareTo(Car other) {
        return distance - other.distance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Car car = (Car) other;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
