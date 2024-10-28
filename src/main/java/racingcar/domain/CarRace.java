package racingcar.domain;

public class CarRace {
    private final Cars cars;
    private final Attempts attempts;

    public CarRace(Cars cars, Attempts attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void startRace() {
        while (!attempts.isEndGame()) {
            cars.getCars().forEach(Car::move);
            attempts.comsumeAttempt();
        }
    }
}
