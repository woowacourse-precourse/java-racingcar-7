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
        RaceService raceService = new RaceService(getCarNames(), getAttemptCount());
        raceService.start();
        outputView.printResult(raceService.getResult());
        outputView.printWinner(raceService.getWinners());
    }

    private int getAttemptCount() {
        outputView.printGetAttemptCountGuide();
        String inputAttemptCount = inputView.getAttemptCount();
        inputValidator.isStringNull(inputAttemptCount);
        int attemptCount = Integer.parseInt(inputAttemptCount);
        inputValidator.validateAttempts(attemptCount);
        return attemptCount;
    }

    private List<String> getCarNames() {
        outputView.printGetCarsNameGuide();
        String carNames = inputView.getCarNames();
        inputValidator.isStringNull(carNames);
        List<String> cars = inputParser.parseCarNames(carNames);
        inputValidator.validateCarNames(cars);
        return cars;
    }
}
