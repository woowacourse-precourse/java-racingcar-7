package racingcar.model;

import java.util.List;

public class RacingGame <T extends Vehicle> {
    protected int tryCount;
    protected List<T> vehicles;

    public RacingGame(int tryCount, List<T> vehicles) {
        this.tryCount = tryCount;
        this.vehicles = vehicles;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<T> getVehicles() {
        return vehicles;
    }
}
