package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceDomain {
    private final List<CarDomain> cars;
    private final Integer lastRound;
    private Integer currentRound = 0;

    private RaceDomain(List<CarDomain> cars, Integer lastRound) {
        this.cars = cars;
        this.lastRound = lastRound;
    }

    public static RaceDomain create(List<CarDomain> cars, Integer lastRound) {
        return new RaceDomain(cars, lastRound);
    }

    public List<CarDomain> getCars() {
        return cars;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public Integer getLastRound() {
        return lastRound;
    }

    public void incrementCurrentRound() {
        this.currentRound++;
    }

    public List<CarDomain> getWinnersInstance() {
        int maxDistance = cars.stream()
                .map(CarDomain::getDistance)
                .max(Integer::compare)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance().equals(maxDistance))
                .collect(Collectors.toList());
    }
}
