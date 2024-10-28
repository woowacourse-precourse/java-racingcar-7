package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.util.random.RaceRandomGenerator;

public class RaceEngine {

    private final RaceRandomGenerator randomGenerator;

    public RaceEngine(RaceRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Race performRace(Race race) {
        List<Car> finishedCars = new ArrayList<>();

        for (Car car : race.getCars()) {
            if (randomGenerator.canMoveForward()) {
                finishedCars.add(new Car(car.getMember(), car.getRacingDistance() + 1));
                continue;
            }
            finishedCars.add(new Car(car.getMember(), car.getRacingDistance()));
        }

        return new Race(finishedCars);
    }
}
