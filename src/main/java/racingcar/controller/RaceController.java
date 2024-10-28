package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceController {
    private final RaceService raceService;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(RaceService raceService, InputView inputView, OutputView outputView) {
        this.raceService = raceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = inputView.inputCars();
        int attempts = inputView.inputAttempts();

        raceService.race(cars, attempts);

        outputView.printRaceResult(cars);
        List<String> winners = raceService.determineWinners(cars);
        outputView.announceWinners(winners);
    }
}