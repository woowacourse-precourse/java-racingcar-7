package racingcar.model;

import java.util.List;

public class Race {

    private final int totalRounds;
    private final List<Car> participatingCars;

    public Race(int totalRounds, List<Car> participatingCars) {
        this.totalRounds = totalRounds;
        this.participatingCars = participatingCars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }
}
