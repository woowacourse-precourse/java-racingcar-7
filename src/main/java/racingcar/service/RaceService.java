package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.CarFactory;
import racingcar.model.car.MoveStrategy;
import racingcar.model.race.RaceManager;

public class RaceService {
    private RaceManager raceManager;

    public void initializeRace(
            String[] carNames,
            MoveStrategy strategy,
            int tryCount
    ) {
        List<Car> cars = initializeCars(carNames, strategy);
        this.raceManager = new RaceManager(cars, tryCount);
    }

    private List<Car> initializeCars(
            String[] carNames,
            MoveStrategy strategy
    ) {
        return Arrays.stream(carNames)
                .map(name -> CarFactory.createCar(name, strategy))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        raceManager.startRace();
    }

    public List<Car> getCars() {
        return raceManager.getCurrentCars();
    }

    public List<String> getWinners() {
        return raceManager.getWinners();
    }
}