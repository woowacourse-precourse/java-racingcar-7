package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getSortedRaceResults() {
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort((c1, c2) -> Long.compare(c2.getRacingDistance(), c1.getRacingDistance()));
        return sortedCars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
