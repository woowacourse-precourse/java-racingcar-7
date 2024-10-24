package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RandomNumberGenerator;
import racingcar.service.CarMakerService;
import racingcar.service.GameService;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new TryCountValidator(), new CarNameValidator());
        CarMakerService carMakerService = new CarMakerService();
        GameService gameService = new GameService(new RandomNumberGenerator());
        WinnerService winnerService = new WinnerService();
        OutputView outputView = new OutputView();

        RacingCarController racingCarController = new RacingCarController(
                inputView, carMakerService, gameService, winnerService, outputView
        );

        racingCarController.startGame();
    }
}
