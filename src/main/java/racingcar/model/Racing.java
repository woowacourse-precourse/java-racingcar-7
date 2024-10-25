package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarStatusDto;

public class Racing {

    private final Cars cars;

    private Racing(Cars cars) {
        this.cars = cars;
    }

    public static Racing from(Cars cars) {
        return new Racing(cars);
    }

    public void runRacing() {
        cars.move();
    }

    public List<CarStatusDto> getResult() {
        return cars.getCarStatusResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Racing racing = (Racing) o;
        return Objects.equals(cars, racing.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
