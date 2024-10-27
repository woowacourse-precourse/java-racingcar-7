package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.CarNameException;
import racingcar.exception.RoundException;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.service.RacingGameService;
import racingcar.util.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        try {
            initializeGame();
            progressGame();
            finalizeGame();
        } catch (CarNameException | RoundException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    // initial
    private void initializeGame() {
        List<Car> cars = initializeCars();
        RandomMoveStrategy decisionGenerator = initializeGenerator();
        RacingCars racingCars = new RacingCars(cars, decisionGenerator);
        this.racingGameService = new RacingGameService(racingCars);
    }

    private List<Car> initializeCars() {
        String carNamesInput = inputView.getCarNames();
        List<String> carNames = parseCarNames(carNamesInput);

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return carList;
    }

    private RandomMoveStrategy initializeGenerator() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new RandomMoveStrategy(randomNumberGenerator);
    }

    private List<String> parseCarNames(String carNamesInput) {
        return List.of(carNamesInput.split(","));
    }

    // progress
    private void progressGame() {
        int rounds = inputView.getRound();
        outputView.printRaceStart();
        playRounds(rounds);
    }

    private void playRounds(int rounds) {
        for (int i = 0; i < rounds; i++) {
            RacingCars racingCars = racingGameService.playRound();
            outputView.printRaceStatus(racingCars);
        }
    }

    // finalize
    private void finalizeGame() {
        List<String> winners = racingGameService.getWinners();
        outputView.printWinners(winners);
    }
}
