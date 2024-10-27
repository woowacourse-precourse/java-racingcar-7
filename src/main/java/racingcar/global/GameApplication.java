package racingcar.global;

import java.util.Map;
import racingcar.car.controller.CarController;
import racingcar.race.controller.RaceController;

public class GameApplication {
    public void start() {
        CarController carController = new CarController();
        RaceController raceController = new RaceController();

        Map<String, String> race = carController.createCars();
        int round = raceController.raceEnterRound();
    }
}
