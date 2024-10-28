package racingcar.model;

import java.util.List;

public class Race {

    private List<Car> cars;
    private int numOfMatches;

    public Race(List<Car> cars) {
        this.cars = cars;
        this.numOfMatches = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public void increaseNumOfMatches() {
        this.numOfMatches++;
    }
}
