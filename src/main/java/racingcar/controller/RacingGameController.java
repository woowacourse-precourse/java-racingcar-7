package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.parser.AttemptParser;
import racingcar.parser.CarNameParser;
import racingcar.service.RacingGameService;
import racingcar.validator.AttemptValidator;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final CarNameParser carNameParser;
    private final CarNameValidator carNameValidator;
    private final AttemptParser attemptParser;
    private final AttemptValidator attemptValidator;
    private final RacingGameService racingGameService;

    public RacingGameController(CarNameParser carNameParser, CarNameValidator carNameValidator,
                                AttemptParser attemptParser, AttemptValidator attemptValidator,
                                RacingGameService racingGameService) {
        this.carNameParser = carNameParser;
        this.carNameValidator = carNameValidator;
        this.attemptParser = attemptParser;
        this.attemptValidator = attemptValidator;
        this.racingGameService = racingGameService;
    }

    public void run() {
        List<String> carNames = getCarNames();
        int attempt = getAttempt();
        List<Car> cars = racingGameService.initialize(carNames, attempt);
        startRace(cars, attempt);
        printRaceWinners(cars);
    }

    private List<String> getCarNames() {
        String inputCarNames = InputView.readCarNames();
        carNameValidator.validate(inputCarNames);
        return carNameParser.parseAndTrimCarNames(inputCarNames);
    }

    private int getAttempt() {
        String inputAttempt = InputView.readAttempts();
        attemptValidator.validate(inputAttempt);
        return attemptParser.parseAttempt(inputAttempt);
    }

    private void startRace(List<Car> cars, int attempt) {
        OutputView.printResultMessage();
        IntStream.range(0, attempt).forEach(stage -> {
            cars.forEach(car -> racingGameService.race(car, stage));
            OutputView.printRacingStage(cars);
        });
    }

    private void printRaceWinners(List<Car> cars) {
        List<String> winnerNames = racingGameService.getWinnerNames(cars);
        OutputView.printWinner(winnerNames);
    }
}
