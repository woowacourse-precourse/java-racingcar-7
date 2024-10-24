package controller;

import constant.Prompt;
import domain.Attempt;
import domain.Cars;
import service.RacingService;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private Cars cars;
    private Attempt attempt;

    public void set() {
        inputRacingSettings();
        startRace();
        result();
    }

    private void inputRacingSettings() {
        cars = new Cars(InputView.inputCars());
        attempt = new Attempt(InputView.inputAttempt());
    }

    public void startRace() {
        System.out.println(Prompt.RACE_RESULT.getMessage());
        racingService.race(cars, attempt.getAttempt());

    }

    private void result() {
        System.out.print(Prompt.WINNER.getMessage());
        OutputView.showWinners(racingService.getWinners(cars));
    }
}
