package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RaceService {
    private Cars cars;

    public void makeCars(List<String> names) {
        cars = Cars.of(names);
    }

    public List<Car> startRace() {
        cars.startRace();
        return cars.getCars();
    }

    public List<Car> getWinner() {
        return cars.getWinners();
    }

}
