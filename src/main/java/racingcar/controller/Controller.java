package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private Racing racing;
    private RacingResult racingResult;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeCars(getCarNames());
        initializeRacing(getTryCount());
        startCarRacing();
        runRacingStages();
        concludeRacing();
    }

    private List<String> getCarNames() {
        return inputView.getInputCarNames();
    }

    private int getTryCount() {
        return inputView.getInputTryCount();
    }

    private void initializeCars(List<String> carNames) {
        cars = new Cars(carNames);
    }

    private void initializeRacing(int tryCount) {
        racing = new Racing();
        racing.saveTryCount(tryCount);
    }

    private void startCarRacing() {
        outputView.printRacingStart();
    }

    private void runRacingStages() {
        while (isEndRacingStage()) {
            executeRacingStage();
        }
    }

    private void executeRacingStage() {
        cars.requestCarMove();
        racing.minusTryCount();
        outputView.printStageResult(cars);
    }

    private boolean isEndRacingStage() {
        return racing.isProgress();
    }

    private void concludeRacing() {
        racingResult = new RacingResult();
        List<String> winnersName = racingResult.getWinnerNames(cars);
        outputView.printWinners(winnersName);
    }
}
