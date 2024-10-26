package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarController racingCarController= new RacingCarController(inputView, racingCarService);
        racingCarController.initializeGame();

    }
}
