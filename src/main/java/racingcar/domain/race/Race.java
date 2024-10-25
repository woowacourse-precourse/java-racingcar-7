package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.util.RaceRandomGenerator;

public class Race {

    private final List<Car> cars;
    private final long times;
    private final RaceRandomGenerator randomGenerator;

    public Race(List<Car> cars, long times, RaceRandomGenerator randomGenerator) {
        this.cars = new ArrayList<>(cars);
        this.times = times;
        this.randomGenerator = randomGenerator;
    }

    public Race performRace() {
        List<Car> finishedCars = new ArrayList<>();
        for (Car car : cars) {
            long carForwardCount = randomGenerator.getMoveForwardTimes(times);
            finishedCars.add(new Car(car.getMember(), carForwardCount));
        }

        return new Race(finishedCars, times, randomGenerator);
    }

    public List<Car> getSortedRaceResults() {
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort((c1, c2) -> Long.compare(c2.getRacingDistance(), c1.getRacingDistance()));
        return sortedCars;
    }
}
