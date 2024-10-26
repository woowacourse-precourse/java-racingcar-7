package racingcar.domain;

public class Race {
    private final TryCount tryCount;
    private final Cars cars;
    private int maxDistance;
    private WinnerCars winnerCars;

    public Race(TryCount tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
        this.maxDistance = 0;
    }


    public void startRace() {
        cars.moveCars();
    }

    public void finishRace() {
        getMaxDistance();
        getWinnerCars();
    }

    private void getMaxDistance() {
        this.maxDistance = cars.getMaxDistance();
    }

    public void getWinnerCars() {
        this.winnerCars = cars.getWinnerCars(this.maxDistance);
    }

}
