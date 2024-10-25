package racingcar.domain;

import java.util.List;

public class RaceLog {

    private final int round;
    private final List<CarDetail> carDetails;

    private RaceLog(int round, List<CarDetail> carDetails) {
        this.round = round;
        this.carDetails = carDetails;
    }

    public static RaceLog from(int round, Cars cars) {
        return new RaceLog(round, cars.getAllCarDetails());
    }
}
