package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int MIN_CONDITION = 0;
    private static final int MAX_CONDITION = 9;

    private final Name name;
    private final Location location;

    private Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public static Car from(String name) {
        return new Car(new Name(name), new Location());
    }

    public void move() {
        if (canMove()) {
            location.moveForward();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN_CONDITION, MAX_CONDITION) >= MOVE_CONDITION;
    }

    public int getCurrentLocation() {
        return location.getLocation();
    }

    public String getCarName() {
        return name.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

