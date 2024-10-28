package racingcar.application;

import racingcar.controller.RacingCarController;
import racingcar.service.AcceleratorService;
import racingcar.service.impl.RandomNumberGeneratorService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.impl.InputViewImpl;
import racingcar.view.impl.OutputViewImpl;

public class RacingCarApplication {
    public void run() {
        AcceleratorService accelerator = new AcceleratorService(new RandomNumberGeneratorService());
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        RacingCarController racingCarController = new RacingCarController(accelerator, inputView, outputView);
        racingCarController.run();
    }
}
