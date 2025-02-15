package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;


public class Car implements Comparable<Car> {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (canMoveForward()) { //값이 4 이상일 때만 +1 이동
            this.distance += 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
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

    @Override
    public String toString() {
        return String.join(" : ", this.name, "-".repeat(this.distance));
    }

    public static List<Car> to(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private boolean canMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
