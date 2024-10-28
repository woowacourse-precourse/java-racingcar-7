package racingcar.application;

import racingcar.controller.RacingCarController;
import racingcar.service.Accelerator;
import racingcar.service.RandomNumberAccelerator;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Accelerator accelerator = new RandomNumberAccelerator(RandomNumberGenerator.createRandomNumberGenerator());
        RacingCarController racingCarController = new RacingCarController(inputView, outputView, accelerator);
        racingCarController.run();
    }
}
