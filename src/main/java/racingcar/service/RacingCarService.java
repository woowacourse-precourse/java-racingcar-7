package racingcar.service;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.MovementStrategy;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceLog;

public class RacingCarService {

    public RaceResult race(List<String> carNames, int raceRound, MovementStrategy movementStrategy) {
        Cars cars = Cars.from(carNames, movementStrategy);
        Race race = Race.from(raceRound, cars);

        race.play();

        List<RaceLog> raceLogs = race.getRaceLogs();
        List<Car> victoryCars = race.getVictoryCars();
        return new RaceResult(raceLogs, victoryCars);
    }
}
