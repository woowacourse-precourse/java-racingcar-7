// AppConfig.java
package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.RandomNumberGeneratorImpl;
import racingcar.utils.InputValidator;
import racingcar.utils.CarNameValidator;
import racingcar.utils.NumberOfTrialsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingCarService racingCarService() {
        return new RacingCarServiceImpl(randomNumberGenerator());
    }

    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGeneratorImpl();
    }

    public InputValidator carNameValidator() {
        return new CarNameValidator();
    }

    public InputValidator numberOfTrialsValidator() {
        return new NumberOfTrialsValidator();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(), inputView(), outputView(), carNameValidator(), numberOfTrialsValidator());
    }
}
