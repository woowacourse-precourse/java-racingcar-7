package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Winners;
import racingcar.service.RacingService;
import racingcar.view.InputProcessor;
import racingcar.view.OutputView;
import racingcar.view.validator.carName.CarNameValidatorFacade;
import racingcar.view.validator.racingNumber.RacingNumberValidatorFacade;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void start() {
        CarNameValidatorFacade carNameValidatorFacade = new CarNameValidatorFacade();
        RacingNumberValidatorFacade racingNumberValidatorFacade = new RacingNumberValidatorFacade();

        InputProcessor inputProcessor = new InputProcessor(carNameValidatorFacade, racingNumberValidatorFacade);
        List<String> carNames = inputProcessor.receiveCarNames();
        Race race = inputProcessor.receiveRacingNumber();

        Cars cars = racingService.enterCars(carNames);
        Winners winners = racingService.startRace(cars, race);
        OutputView outputView = new OutputView();
        outputView.displayWinners(winners);
    }
}
