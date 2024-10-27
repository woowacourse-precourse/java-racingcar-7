package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.MoveForwardService;
import racingcar.service.RacingInputValidateService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingController racingController = new RacingController(new RacingInputValidateService(),
                new MoveForwardService(), new WinnerService());
        racingController.run();
    }
}
