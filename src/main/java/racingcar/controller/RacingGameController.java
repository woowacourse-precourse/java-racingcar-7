package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarService;

public class RacingGameController {
    public static void run() {
        List<Car> raceParticipants = CarService.setParticipants();

    }

}
