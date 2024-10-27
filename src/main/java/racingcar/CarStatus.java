package racingcar;

import java.util.Objects;

public class CarStatus {
    private static final int STARTING_POINT = 0;

    private final int location;

    public static CarStatus initStartingStatus() {
        return new CarStatus(STARTING_POINT);
    }

    CarStatus(int location) {
        this.location = location;
    }

    public boolean isAhead(CarStatus other) {
        return this.location > other.location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus = (CarStatus) o;
        return location == carStatus.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
