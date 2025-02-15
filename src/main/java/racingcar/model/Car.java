package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        int n = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (n >= MOVEMENT_THRESHOLD) {
            distance++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car castedCar) {
            return name.equals(castedCar.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
