package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RaceServiceImpl implements RaceService {
    private Cars cars;

    @Override
    public void makeCars(List<String> names) {
        cars = Cars.of(names);
    }

    @Override
    public List<Car> startRace() {
        cars.startRace();
        return cars.getCars();
    }

    @Override
    public List<Car> getWinner() {
        return cars.getWinners();
    }

}
