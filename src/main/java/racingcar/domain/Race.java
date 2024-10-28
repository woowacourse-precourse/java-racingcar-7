package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars raceCars;
    private Count remainingRounds;

    public Race(Cars raceCars, Count totalRounds) {
        this.raceCars = raceCars;
        this.remainingRounds = totalRounds;
    }

    public List<Car> moveAllCarsAndGetStatus(NumberGenerator numberGenerator) {
        raceCars.moveAll(numberGenerator);
        remainingRounds = remainingRounds.decrement();
        return raceCars.getCars();
    }

    public List<Car> getWinners() {
        return raceCars.determineWinners();
    }

    public boolean isRaceComplete() {
        return remainingRounds.isComplete();
    }
}