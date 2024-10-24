package racingcar.domain;

import java.util.List;

public class RaceDomain {
    private final List<CarDomain> cars;
    private Integer round;

    private RaceDomain(List<CarDomain> cars, Integer currentRound) {
        this.cars = cars;
        this.round = currentRound;
    }

    public static RaceDomain create(List<CarDomain> cars, Integer currentRound) {
        return new RaceDomain(cars, currentRound);
    }

    public List<CarDomain> getCars() {
        return cars;
    }

    public Integer getRound() {
        return round;
    }

    public void incrementRound() {
        this.round++;
    }
}
