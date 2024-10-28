package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.InputValidator;
import racingcar.service.RacingCarService;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.StringHandler;
import racingcar.view.RacingCarView;

public class Application {
    // 입력
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarController racingCarController = new RacingCarController(new RacingCarView(), new InputValidator(),
                new StringHandler(), new RacingCarService(new RandomNumberGenerator()));

        racingCarController.start();

    }
}
