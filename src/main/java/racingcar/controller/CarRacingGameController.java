package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.WinnerDecision;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    private final List<Car> cars = new ArrayList<>();
    private int attemptCount;

    public void run() {
        initializeGame();
        playRounds();
        showWinners();
    }

    private void initializeGame() {
        List<String> carNames = InputView.getCarNames();
        carNames.forEach(name -> {
            InputValidator.validateCarName(name);
            cars.add(Car.create(name));
        });

        attemptCount = InputView.getAttemptCount();
        InputValidator.validateAttemptCount(attemptCount);
    }

    private void playRounds() {
        for (int round = 0; round < attemptCount; round++) {
            playOneRound();
            OutputView.displayRaceProgress(cars);
        }
    }

    private void playOneRound() {
        cars.forEach(car -> {
            int randomNumber = Car.randomNumberGenerator();
            car.move(randomNumber);
        });
    }

    private void showWinners() {
        List<Car> winners = WinnerDecision.determineWinners(cars);
        OutputView.displayWinners(winners);
    }
}
