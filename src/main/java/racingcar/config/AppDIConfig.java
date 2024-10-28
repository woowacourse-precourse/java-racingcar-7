package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppDIConfig {

    private final RacingCarRepositoryImpl racingCarRepository;
    private final RacingCarService racingCarService;
    private final RacingCarController racingCarController;

    public AppDIConfig() {
        this.racingCarRepository = new RacingCarRepositoryImpl();
        this.racingCarService = new RacingCarService(racingCarRepository);
        this.racingCarController = new RacingCarController(new InputView(), new OutputView(), racingCarService);
    }

    public RacingCarController getRacingCarController() {
        return racingCarController;
    }

    public RacingCarRepositoryImpl getRacingCarRepository() {
        return racingCarRepository;
    }

    public RacingCarService getRacingCarService() {
        return racingCarService;
    }
}