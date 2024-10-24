package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.WinnerService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new TryCountValidator(), new CarNameValidator());
        WinnerService winnerService = new WinnerService();
        OutputView outputView = new OutputView();

        RacingCarController racingCarController = new RacingCarController(
                inputView, winnerService, outputView
        );

        racingCarController.playGame();
    }
}
