package racingcar.domain.race;

import racingcar.domain.car.CarName;

public class RoundRecord {
    private final CarName carName;
    private final int distance;

    public RoundRecord(String carName, int distance) {
        this.carName = new CarName(carName);
        this.distance = distance;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance;
    }
}
