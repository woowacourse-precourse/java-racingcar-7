package racingcar.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.service.RacingService;
import racingcar.util.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingService racingService;

    public RacingController() {
        initializeGame();
    }

    public void playGame() {
        progressGame();
        finalizeGame();
    }

    private void initializeGame() {
        Collection<Car> cars = createCars();
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(new RandomNumberGenerator());
        RacingCars racingCars = new RacingCars(cars, moveStrategy);
        this.racingService = new RacingService(racingCars);
    }

    private Collection<Car> createCars() {
        String carNamesInput = inputView.getCarNames();
        Collection<String> carNames = List.of(carNamesInput.split(","));
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void progressGame() {
        int rounds = inputView.getRound();
        outputView.printRaceStart();
        runRounds(rounds);
    }

    private void runRounds(int rounds) {
        IntStream.range(0, rounds)
                .forEach(i -> runSingleRound());
    }

    private void runSingleRound() {
        RacingCars racingCars = racingService.playRound();
        outputView.printRaceStatus(racingCars);
    }

    private void finalizeGame() {
        Collection<String> winners = racingService.getWinners();
        outputView.printWinners(winners);
    }
}
