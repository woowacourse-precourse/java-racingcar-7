package racingcar.controller;

import racingcar.config.GameConfig;
import racingcar.service.CarService;

public class CarController {

    private final CarService carService;

    public CarController(){
        this.carService = new CarService();
    }

    public void run() {
        GameConfig config = carService.initializeGame();
        carService.startRace(config.getCars(), config.getAttemptCount());
        carService.showResults(config.getCars());
    }
}
