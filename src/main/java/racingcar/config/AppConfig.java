package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final boolean isTest;
    private AppConfig(boolean isTest) {
        this.isTest = isTest;
    }

    public static class Holder {
        private static final AppConfig INSTANCE = new AppConfig(false);
    }
    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public static AppConfig createNewInstance() {
        return new AppConfig(true);
    }

    public CarRepository getCarRepository() {
        if (isTest) {
            return InMemoryCarRepository.createNewInstance();
        }
        return InMemoryCarRepository.getInstance();
    }

    public RaceService getRaceService() {
        if (isTest) {
            return RaceServiceImpl.createNewInstance();
        }
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
