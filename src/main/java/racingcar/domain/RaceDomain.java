package racingcar.domain;

public class RaceDomain {
    private final CarDomains cars;
    private final Integer lastRound;
    private Integer currentRound = 0;

    private RaceDomain(CarDomains cars, Integer lastRound) {
        this.cars = cars;
        this.lastRound = lastRound;
    }

    public static RaceDomain create(CarDomains cars, Integer lastRound) {
        return new RaceDomain(cars, lastRound);
    }

    public CarDomains getCars() {
        return cars;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public Integer getLastRound() {
        return lastRound;
    }

    public void executeOneRound() {
        incrementCurrentRound();
        cars.executeOneRound();
    }

    public CarDomains getWinnersInstance() {
        return cars.getWinnersInstance();
    }

    private void incrementCurrentRound() {
        this.currentRound++;
    }
}
