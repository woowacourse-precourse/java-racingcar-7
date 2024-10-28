package racingcar.model;

import java.util.List;

public class Race {

    private final List<Car> raceCars;
    private final int attemptNum;

    public Race(List<Car> raceCars, int attemptNum) {
        this.attemptNum = attemptNum;
        this.raceCars = raceCars;
    }

    public List<Car> getRaceCars() { return raceCars; }

    public int getAttemptNum() { return attemptNum; }
}
