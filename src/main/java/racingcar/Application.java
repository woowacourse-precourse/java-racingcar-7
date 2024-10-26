package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RacingCarRepositoryImpl racingCarRepository = new RacingCarRepositoryImpl();
    private static final RacingCarService racingCarService = new RacingCarService(racingCarRepository);
    private static final RacingCarController racingCarController = new RacingCarController(racingCarService);

    public static void main(String[] args) {
        racingCarController.setRacingCar(inputView);
        racingCarController.openingRacingGame(inputView, outputView);
    }
}
