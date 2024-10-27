package racingcar.dto;

import java.util.Objects;
import racingcar.constants.StringConstants;
import racingcar.domain.car.Car;

public class CarStatus {

    private final String name;
    private final int position;

    private CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarStatus from(Car car) {
        return new CarStatus(car.getName(), car.getPosition());
    }

    public static CarStatus of(String name, int position) {
        return new CarStatus(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name +
                StringConstants.CAR_NAME_POSITION_SEPARATOR +
                StringConstants.CAR_POSTION_INDICATOR.repeat(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarStatus carStatus)) {
            return false;
        }
        return getPosition() == carStatus.getPosition() && Objects.equals(getName(), carStatus.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
