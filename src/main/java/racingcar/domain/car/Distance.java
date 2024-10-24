package racingcar.domain.car;

import java.util.Objects;

public class Distance {

    private int distance;
    public static int ZERO_DISTANCE = 0;

    public Distance() {
        this.distance = ZERO_DISTANCE;
    }

    public void increase(){
        distance ++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(distance);
    }
}
