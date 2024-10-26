package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceLog;

public class RacingCarService {

    public RaceResult race(List<String> carNames, int raceRound) {
        Cars cars = Cars.from(carNames);

        Race race = Race.from(raceRound, cars);
        race.play();

        List<RaceLog> raceLogs = race.getRaceLogs();
        List<Car> victoryCars = race.getVictoryCars();
        return new RaceResult(raceLogs, victoryCars);
    }
}
