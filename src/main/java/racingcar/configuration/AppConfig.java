package racingcar.configuration;

import racingcar.controller.RacingController;
import racingcar.repository.MemoryRepository;
import racingcar.repository.Repository;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * Controlller, Service, Repository, InputView, OutputView 객체를 생성하고,
 * 클래스 인터페이스 구현체를 선택해서 의존성 주입한다.
 */
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

    public RacingController getCarRacingController() {
        return new RacingController(getInputView(), getOutputView(),
                getCarRacingService());
    }
}
