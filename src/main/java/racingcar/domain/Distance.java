package racingcar.domain;

import java.util.Objects;

public class Distance {
    private static final String INVALID_DISTANCE = "움직인 거리는 음수가 될 수 없습니다.";
    private final int distanceValue;

    public Distance(int distanceValue) {
        if (distanceValue < 0) {
            throw new IllegalArgumentException(INVALID_DISTANCE);
        }
        this.distanceValue = distanceValue;
    }

    public Distance increaseDistance() {
        return new Distance(this.distanceValue + 1);
    }

    public int getDistanceValue() {
        return distanceValue;
    }

    public int max(int maxDistance) {
        if (this.distanceValue > maxDistance) {
            return this.distanceValue;
        }
        return maxDistance;
    }

    public boolean isSameDistance(int distance) {
        if (this.distanceValue == distance) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance = (Distance) o;
        return Objects.equals(distanceValue, distance.distanceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceValue);
    }
}
