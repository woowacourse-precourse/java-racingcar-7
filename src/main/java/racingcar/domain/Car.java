package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    public Car(String name) {
        String trimName = name.trim();
        validateName(trimName);
        this.name = trimName;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 필수입니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
        }
    }

    public void move() {
        if (canMove()) {
            distance++;
        }
    }

    public CarDetail getCarDetail() {
        return new CarDetail(name, distance);
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
