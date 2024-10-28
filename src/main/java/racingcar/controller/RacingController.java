package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Winners;
import racingcar.service.RacingService;
import racingcar.view.InputProcessor;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;
    private final InputProcessor inputProcessor;

    public RacingController(RacingService racingService, InputProcessor inputProcessor) {
        this.racingService = racingService;
        this.inputProcessor = inputProcessor;
    }

    public void start() {
        List<String> carNames = inputProcessor.receiveCarNames();
        Race race = inputProcessor.receiveRacingNumber();

        Cars cars = racingService.enterCars(carNames);
        Winners winners = racingService.startRace(cars, race);

        OutputView.getInstance().displayWinners(winners);
    }
}
