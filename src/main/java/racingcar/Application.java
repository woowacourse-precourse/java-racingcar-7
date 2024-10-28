package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        CarService carService = new CarService(randomNumberGenerator);
        GameService gameService = new GameService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CarRacingController carRacingController =
                new CarRacingController(carService, gameService, inputView, outputView);

        carRacingController.startRace();
    }
}
