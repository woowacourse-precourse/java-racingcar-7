package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarSetupService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final CarSetupService carSetupService;

    public RacingGameController(
            RacingGameService racingGameService,
            InputView inputView,
            OutputView outputView,
            CarSetupService carSetupService) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.carSetupService = carSetupService;
    }

    public void run() {
        List<Car> cars = setupCars();
        int count = setupAttempCount();

        outputView.displayResult();
        raceGame(cars, count);
        displayWinners(cars);
    }

    private List<Car> setupCars() {
        outputView.displayCarNameInput();
        String inputValue = inputView.inputCarNames();
        return carSetupService.parseCarNames(inputValue);
    }

    private int setupAttempCount() {
        outputView.displayAttemptCount();
        return carSetupService.parseAttemptCount(inputView.inputAttemptCount());
    }

    private void raceGame(List<Car> cars, int count) {
        racingGameService.raceGame(cars, count);
    }

    private void displayWinners(List<Car> cars) {
        List<String> winners = racingGameService.findWinners(cars);
        outputView.displayWinner(winners);
    }
}
