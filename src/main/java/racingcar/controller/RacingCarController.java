package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.TryCount;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Race race = new Race();
        List<String> carNames = scanCarNames();
        makeCars(race, carNames);
        TryCount tryCount = scanTryCount();
        raceCars(race, tryCount);
        printWinner(race);
    }

    private List<String> scanCarNames(){
        outputView.printScanCarsMessage();
        return inputView.scanCarNames();
    }

    private void makeCars(Race race, List<String> carNames) {
        race.makeCars(carNames);
    }

    private TryCount scanTryCount(){
        outputView.printTryOutCountMessage();
        return new TryCount(inputView.scanTryCount(), new TryCountValidator());
    }

    private void raceCars(Race race, TryCount tryCount) {
        outputView.printMoveResultMessage();
        while (tryCount.isNotZero()) {
            race.raceCars();
            outputView.printMovedCars(race.getCars());
            tryCount.reduceTryCount();
        }
    }

    private void printWinner(Race race) {
        outputView.printWinner(race.findWinner());
    }
}
