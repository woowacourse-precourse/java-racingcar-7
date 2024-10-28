package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void plusLocation() {
        this.location += 1;
    }

    public boolean isMove() {
        return pickNumber() >= 4;
    }

    private static int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return (Objects.equals(name, car.name) && Objects.equals(location, car.location));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return name;
    }
}
