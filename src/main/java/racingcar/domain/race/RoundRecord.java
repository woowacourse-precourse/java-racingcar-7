package racingcar.domain.race;

import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;

public class RoundRecord {
    private final CarName carName;
    private final Distance distance;

    public RoundRecord(String carName, int distance) {
        this.carName = new CarName(carName);
        this.distance = new Distance(distance);
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
