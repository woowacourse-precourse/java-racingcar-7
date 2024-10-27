package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.CarService;
import racingcar.util.PlayerNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarService carService = new CarService(playerNameValidator);

        RacingController racingController = new RacingController(inputView, outputView, carService);
        racingController.run();
    }
}
