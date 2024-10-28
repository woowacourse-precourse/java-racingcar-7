package racingcar.model;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int move(int randomDistance) {
        return this.distance + randomDistance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Distance comparingDistance = (Distance) obj;
        return distance == comparingDistance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
