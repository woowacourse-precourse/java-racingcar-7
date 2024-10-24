package racingcar.configuration;

import racingcar.controller.RacingControllerImpl;
import racingcar.repository.MemoryRepository;
import racingcar.repository.Repository;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public InputView getInputView() {
        return new ConsoleInputView();
    }

    public OutputView getOutputView() {
        return new ConsoleOutputView();
    }

    public Repository getRepository() {
        return new MemoryRepository();
    }

    public RacingService getCarRacingService() {
        return new RacingServiceImpl(getRepository());
    }

    public RacingControllerImpl getCarRacingController() {
        return new RacingControllerImpl(getInputView(), getOutputView(),
                getCarRacingService());
    }
}
