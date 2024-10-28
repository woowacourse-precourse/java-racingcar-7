package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputProcessor;
import racingcar.view.validator.carName.CarNameValidatorFacade;
import racingcar.view.validator.racingNumber.RacingNumberValidatorFacade;

public class AppConfig {

    public RacingService racingService() {
        return new RacingService();
    }

    public CarNameValidatorFacade carNameValidatorFacade() {
        return new CarNameValidatorFacade();
    }

    public RacingNumberValidatorFacade racingNumberValidatorFacade() {
        return new RacingNumberValidatorFacade();
    }

    public InputProcessor inputProcessor() {
        return new InputProcessor(carNameValidatorFacade(), racingNumberValidatorFacade());
    }

    public RacingController racingController() {
        return new RacingController(racingService(), inputProcessor());
    }
}
