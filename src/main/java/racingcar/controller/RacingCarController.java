package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.service.RacingCarService;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void start() {
        List<RacingCar> cars = racingCarService.inputCars();
        int trial= racingCarService.inputTrial();
        racingCarService.racing(cars,trial);
        List<String> result = racingCarService.getResult(cars);
        racingCarService.printWinners(result);
    }

}
