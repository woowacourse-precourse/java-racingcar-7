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
        outputView.printGetCarsNameGuide();
        String carNames = inputView.getCarsName();
        outputView.printGetAttemptCountGuide();
        int attemptCount = inputView.getAttemptCount();
        inputValidator.validateAttempts(attemptCount);
        inputValidator.isStringNull(carNames);
        List<String> cars = inputParser.parseInput(carNames);
        inputValidator.validateCarNames(cars);

        RaceService raceService = new RaceService(attemptCount, cars);
        raceService.raceStart();
        outputView.printResult(raceService.getResult());
        outputView.printWinner(raceService.getWinners());
    }
}
