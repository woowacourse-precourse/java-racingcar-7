package racingcar;

import java.util.Objects;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final CarName carName;
    private int location;

    public RacingCar(CarName carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public boolean isSameLocation(int location) {
        return this.location == location;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final RacingCar racingCar)) {
            return false;
        }
        return location == racingCar.location && Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, location);
    }

    public int getLocation() {
        return location;
    }

    public String getCarNameValue() {
        return carName.getName();
    }
}
