package racingcar.Domain;

import java.util.List;

public class Game {
    private final int trial;
    private final List<Car> cars;
    public int trialNumber = 0;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }
    public void increasetrialNum() {
        this.trialNumber++;
    }

    public boolean isTrialComplete() {
        return this.trial == this.trialNumber;
    }
}
