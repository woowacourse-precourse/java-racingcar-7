package racingcar.model;

import java.util.Objects;

public class CarDistance {
    private int distance;

    public CarDistance() {
        this.distance = 0;
    }

    public void stepForward() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDistance distance1 = (CarDistance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(distance);
    }

}
