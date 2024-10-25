package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceService = new RaceService();
    }

    public void run() {
        try {
            List<Car> cars = inputView.getCar();
            int attempts = inputView.getNumberOfAttempt();
            outputView.printRaceStart();
            raceService.start(cars, attempts);
            outputView.printWinners(raceService.getWinners(cars));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }
}
