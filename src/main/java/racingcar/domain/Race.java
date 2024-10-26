package racingcar.domain;

public class Race {
    private final TryCount tryCount;
    private final Cars cars;

    public Race(TryCount tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public boolean isFinishRace() {
        return tryCount.isZero();
    }

    public Cars getCars() {
        return cars;
    }

    public void doRace() {
        cars.moveCars();
        tryCount.decrease();
    }

    public WinnerCars getWinnerCars() {
        getMaxDistance();
        return cars.getWinnerCars(getMaxDistance());
    }

    private int getMaxDistance() {
        return cars.getMaxDistance();
    }

}
