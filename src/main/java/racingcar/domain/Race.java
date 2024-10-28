package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars raceCars;
    private Count remainingRounds;

    public Race(List<String> carNames, int totalRounds) {
        this.raceCars = new Cars(carNames);
        this.remainingRounds = Count.newInstance(totalRounds);
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