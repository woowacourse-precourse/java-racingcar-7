package racingcar.common.config;

import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarService;
import racingcar.domain.racing.JudgeService;
import racingcar.domain.racing.RacingService;
import racingcar.interfaces.input.InputHandlerImpl;
import racingcar.interfaces.output.OutputHandler;
import racingcar.interfaces.racing.RacingController;
import racingcar.infrastructures.racing.RandomRacingStrategy;

public class RacingCarConfig {

    public RacingController getRacingController() {
        CarFactory carFactory = new CarFactory();
        CarService carService = new CarService(carFactory);
        RandomRacingStrategy randomRacingStrategy = new RandomRacingStrategy();
        RacingService racingService = new RacingService(randomRacingStrategy);
        JudgeService judgeService = new JudgeService();
        InputHandlerImpl inputHandler = new InputHandlerImpl();
        OutputHandler outputHandler = new OutputHandler();

        return new RacingController(carService, racingService, judgeService, inputHandler, outputHandler);
    }
}
