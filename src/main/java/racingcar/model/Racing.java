package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarStatusDto;

public class Racing {

    private final Cars cars;
    private final RacingCount racingCount;

    private Racing(List<String> cars, int tryCount) {
        this.cars = Cars.fromNames(cars);
        this.racingCount = RacingCount.from(tryCount);
    }

    public static Racing of(List<String> cars, int tryCount) {
        return new Racing(cars, tryCount);
    }

    public void run() {
        cars.move();
    }

    public boolean can() {
        return racingCount.isTry();
    }

    public void deductTryCount() {
        racingCount.deduct();
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
