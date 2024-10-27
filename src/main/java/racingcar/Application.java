package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.service.CarService;
import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        CarController carController = new CarController(carService);
        carController.createCars();

        GameService gameService = new GameService(carService.getCars());
        GameController gameController = new GameController(carService, gameService);
        gameController.startGame();
    }
}
