package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class RacingController {

    void run() {
        RacingCar racingCar1 = new RacingCar("car1");
        RacingCar racingCar2 = new RacingCar("car2");

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2));

        int totalLaps = 2;
        for (int i = 0; i < totalLaps; i++) {
            racingCars.race();
        }

        List<RacingCar> winners = racingCars.getWinners();
    }

}
