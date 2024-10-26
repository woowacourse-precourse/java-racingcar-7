package racingcar.controller;

import racingcar.Service.GameService;
import racingcar.repository.CarRepository;

public class Controller {
    private GameService gameService = new GameService();
    private CarRepository carRepository = new CarRepository();

}
