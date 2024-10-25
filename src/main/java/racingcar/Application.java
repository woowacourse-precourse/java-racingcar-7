package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        GameService gameService = new GameService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CarRacingController carRacingController =
                new CarRacingController(carService, gameService, inputView, outputView);

        carRacingController.startRace();
    }
}
