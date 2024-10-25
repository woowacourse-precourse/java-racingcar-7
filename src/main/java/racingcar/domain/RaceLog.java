package racingcar.domain;

import java.util.List;

public class RaceLog {

    private final List<CarStatus> carStatuses;

    private RaceLog(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static RaceLog from(Cars cars) {
        return new RaceLog(cars.getAllCarStatuses());
    }

    public List<CarStatus> getCarDetails() {
        return carStatuses;
    }
}
