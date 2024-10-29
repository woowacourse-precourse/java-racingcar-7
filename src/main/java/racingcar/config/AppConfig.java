package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.controller.RacingCarControllerImpl;
import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;
import racingcar.repository.InMemoryRacingHistoryRepository;
import racingcar.repository.RacingHistoryRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.InputParsingService;
import racingcar.service.InputParsingServiceImpl;
import racingcar.service.RacingHistoryService;
import racingcar.service.RacingHistoryServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingCarController racingCarController() {
        return new RacingCarControllerImpl(
                inputView(),
                outputView(),
                inputParsingService(),
                racingService(),
                carService(),
                racingHistoryService()
        );
    }

    private CarService carService() {
        return new CarServiceImpl(carRepository());
    }

    private InputParsingService inputParsingService() {
        return new InputParsingServiceImpl();
    }

    private RacingHistoryService racingHistoryService() {
        return new RacingHistoryServiceImpl(racingHistoryRepository());
    }

    private RacingService racingService() {
        return new RacingServiceImpl(carRepository(), racingHistoryRepository());
    }

    private CarRepository carRepository() {
        return InMemoryCarRepository.getInstance();
    }

    private RacingHistoryRepository racingHistoryRepository() {
        return InMemoryRacingHistoryRepository.getInstance();
    }

    private InputView inputView() {
        return new ConsoleInputView();
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }
}
