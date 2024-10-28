package racingcar.race;

import java.util.List;
import racingcar.car.Car;

public class RaceController {
    private static final RaceService raceService = new RaceService();

    public void race(List<Car> cars) {
        raceService.race(cars);
    }

    public List<String> getChampion (List<Car> participant) {
        return raceService.getChampion(participant);
    }
}
