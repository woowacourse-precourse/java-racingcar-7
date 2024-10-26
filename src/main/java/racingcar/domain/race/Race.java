package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Race {

    private final RoundExecutor roundExecutor;
    private final Cars cars;
    private final List<RaceLog> raceLogs = new ArrayList<>();

    private Race(int raceRound, Cars cars) {
        this.roundExecutor = new RoundExecutor(raceRound);
        this.cars = cars;
    }

    public static Race from(int raceRound, Cars cars) {
        return new Race(raceRound, cars);
    }

    public void play() {
        roundExecutor.executeAllRound(() -> {
            cars.moveAll();
            raceLogs.add(RaceLog.from(cars));
        });
    }

    public List<RaceLog> getRaceLogs() {
        return List.copyOf(raceLogs);
    }

    public List<Car> getVictoryCars() {
        return cars.getMaxCars();
    }
}
