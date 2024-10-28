package racingcar.domain.history;

import racingcar.domain.car.RacingCar;

public class RacingHistory extends RacingCar {

    public RacingHistory(String name, int distance) {
        super(name, distance);
    }

    public String getRacingCarName() {
        return super.getName();
    }

    public int getDistance() {
        return super.getDistance();
    }

    public String getPrintDistance() {
        return "-".repeat(Math.max(0, getDistance()));
    }
}
