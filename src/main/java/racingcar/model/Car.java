package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

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
        if(canMove()){
            location.moveForward();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
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

