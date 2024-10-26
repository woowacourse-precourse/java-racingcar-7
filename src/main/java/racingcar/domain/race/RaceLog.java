package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.CarStatus;
import racingcar.domain.car.Cars;

public class RaceLog {

    private final List<CarStatus> carStatuses;

    private RaceLog(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static RaceLog from(Cars cars) {
        return new RaceLog(cars.getAllCarStatuses());
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
