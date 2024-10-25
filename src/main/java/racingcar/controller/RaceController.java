package racingcar.controller;

import static racingcar.constant.Constant.*;

import java.util.List;
import racingcar.model.Parser;
import racingcar.model.RaceService;
import racingcar.model.Validator;
import racingcar.model.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;
    private final Validator validator;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, Parser parser, Validator validator,
                          RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.validator = validator;
        this.raceService = raceService;
    }

    public void run() {
        List<String> carNames = getValidatedCarNames();
        int attemptCount = getValidatedAttemptCount();

        List<Car> cars = raceService.createCars(carNames);
        runRace(attemptCount, cars);
        displayWinners(cars);
    }

    private List<String> getValidatedCarNames() {
        String carNamesInput = inputView.getCarNamesInput();
        List<String> carNames = parser.parseCarNames(carNamesInput);
        validator.validateCarNames(carNames);
        return carNames;
    }

    private int getValidatedAttemptCount() {
        String attemptCountInput = inputView.getAttemptCountInput();
        validator.validateAttemptCount(attemptCountInput);
        return parser.convertStringToInt(attemptCountInput);
    }

    private void runRace(int attemptCount, List<Car> cars) {
        outputView.printStartMessage();
        for (int i = 0; i < attemptCount; i++) {
            raceService.raceOnce(cars);
            outputView.printRaceProgress(cars);
        }
    }

    private void displayWinners(List<Car> cars) {
        List<String> winners = raceService.determineWinners(cars);
        String joinedWinnerNames = parser.joinWithJoiner(winners, WINNER_NAME_JOINER);
        outputView.printWinners(joinedWinnerNames);
    }
}
