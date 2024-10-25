package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarStatusDto;

public class Racing {

    private final Cars cars;
    private final RacingCount racingCount;

    private Racing(Cars cars, RacingCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public static Racing of(Cars cars, RacingCount racingCount) {
        return new Racing(cars, racingCount);
    }

    public void runRacing() {
        cars.move();
    }

    public List<CarStatusDto> getResult() {
        return cars.getCarStatusResult();
    }

    public List<String> getWinners() {
        return cars.findWinnersByMaxPosition();
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
        return Objects.equals(cars, racing.cars) && Objects.equals(racingCount, racing.racingCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, racingCount);
    }
}
