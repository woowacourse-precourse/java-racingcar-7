package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private AppConfig() {}

    public static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public CarRepository getCarRepository() {
        return InMemoryCarRepository.getInstance();
    }

    public RaceService getRaceService() {
        return RaceServiceImpl.getInstance();
    }

    public InputView getInputView() {
        return InputView.getInstance();
    }

    public OutputView getOutputView() {
        return OutputView.getInstance();
    }

    public RaceController getRaceController() {
        return RaceController.getInstance(getRaceService(), getInputView(), getOutputView());
    }
}
