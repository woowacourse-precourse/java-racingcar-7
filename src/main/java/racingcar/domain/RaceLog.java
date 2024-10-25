package racingcar.domain;

import java.util.List;

public class RaceLog {

    private final List<CarDetail> carDetails;

    private RaceLog(List<CarDetail> carDetails) {
        this.carDetails = carDetails;
    }

    public static RaceLog from(Cars cars) {
        return new RaceLog(cars.getAllCarDetails());
    }

    public List<CarDetail> getCarDetails() {
        return carDetails;
    }
}
