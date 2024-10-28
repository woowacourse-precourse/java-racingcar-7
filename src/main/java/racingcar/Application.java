package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarService racingCarService = new RacingCarService(new InputView(), new OutputView());
        RacingCarController racingCarController = new RacingCarController(racingCarService);
        racingCarController.start();
    }
}
