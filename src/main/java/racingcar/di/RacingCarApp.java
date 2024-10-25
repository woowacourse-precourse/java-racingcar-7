package racingcar.di;

import racingcar.controller.RacingCarController;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApp {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarRepository racingCarRepository = new RacingCarRepository();
        RacingCarService racingCarService = new RacingCarService(racingCarRepository);

        RacingCarController racingCarController = new RacingCarController(
                inputView,
                outputView,
                racingCarService);

        racingCarController.run();
    }
}
