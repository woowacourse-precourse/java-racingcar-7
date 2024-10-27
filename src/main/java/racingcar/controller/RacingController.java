package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Winners;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void start() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.receiveCarNames();
        Race race = inputView.receiveRacingNumber();

        Cars cars = racingService.enterCars(carNames);
        Winners winners = racingService.startRace(cars, race);
        OutputView outputView = new OutputView();
        outputView.displayWinners(winners);
    }
}
