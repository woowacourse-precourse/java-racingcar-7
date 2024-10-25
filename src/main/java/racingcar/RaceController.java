package racingcar;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();
    private String carNames;
    private int attemptCount;
    private List<String> cars;

    public void start(){
        outputView.printGetCarsNameGuide();
        this. carNames = inputView.getCarsName();
        outputView.printGetAttemptCountGuide();
        this. attemptCount = inputView.getAttemptCount();
        inputValidator.validateAttempts(attemptCount);
        inputValidator.isStringNull(carNames);
        this. cars = inputParser.parseInput(carNames);
        inputValidator.validateCarNames(cars);

        RaceService raceService = new RaceService(attemptCount, cars);
        raceService.raceStart();
        outputView.printResult(raceService.getResult());
        outputView.printWinner(raceService.getWinners());
    }
}
