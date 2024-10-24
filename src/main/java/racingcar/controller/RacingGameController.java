package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputValidator inputValidator;
    private RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputValidator = new InputValidator(inputView);
    }

    public void run() {
        initializeGame();
        runAllRaces();
        printFinalWinners();
    }

    private void initializeGame() {
        List<String> carNames = getValidatedCarNames();
        initializeRacingGame(carNames);
        printInitialResults();
    }

    private List<String> getValidatedCarNames() {
        return inputValidator.getValidatedCarNames();
    }

    private void initializeRacingGame(List<String> carNames) {
        racingGameService = new RacingGameService(carNames);
    }

    private void printInitialResults() {
        outputView.printResultHeader();
        outputView.printRaceResults(racingGameService.getRacingCars());
    }

    private void runAllRaces() {
        int tryCount = inputValidator.getValidatedTryCount();
        racingGameService.startRace(tryCount);
        outputView.printRaceResults(racingGameService.getRacingCars());
    }

    private void printFinalWinners() {
        outputView.printWinners(racingGameService.findWinners());
    }

}
