package racingcar.controller;

import racingcar.parser.InputParser;
import racingcar.service.RaceService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    public void start() {
        RaceService raceService = new RaceService(getCars(), getAttemptCount());
        raceService.raceStart();
        outputView.printResult(raceService.getResult());
        outputView.printWinner(raceService.getWinners());
    }

    private int getAttemptCount() {
        outputView.printGetAttemptCountGuide();
        String inputViewAttemptCount = inputView.getAttemptCount();
        inputValidator.isStringNull(inputViewAttemptCount);
        int attemptCount = Integer.parseInt(inputViewAttemptCount);
        inputValidator.validateAttempts(attemptCount);
        return attemptCount;
    }

    private List<String> getCars() {
        outputView.printGetCarsNameGuide();
        String carNames = inputView.getCarsName();
        inputValidator.isStringNull(carNames);
        List<String> cars = inputParser.parseInput(carNames);
        inputValidator.validateCarNames(cars);
        return cars;
    }
}
