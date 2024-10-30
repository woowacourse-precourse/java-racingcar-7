package racingcar.controller;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import racingcar.dto.InputRequest;
import racingcar.dto.OutputResponse;
import racingcar.message.OutputMessage;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.service.RacingService;
import racingcar.util.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingService racingService;
    private int rounds;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeGame();
    }

    public void playGame() {
        progressGame();
        finalizeGame();
    }

    private void initializeGame() {
        InputRequest inputRequest = inputView.getInput();
        Collection<Car> cars = createCars(inputRequest.carNames());
        rounds = inputRequest.roundCount();
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy(new RandomNumberGenerator());
        racingService = new RacingService(new RacingCars(cars, moveStrategy));
    }

    private Collection<Car> createCars(String carNamesInput) {
        return Stream.of(carNamesInput.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void progressGame() {
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
        OutputResponse outputResponse = OutputResponse.of(OutputMessage.FINAL_WINNER.getMessage(), winners);
        outputView.printWinners(outputResponse);
    }
}
