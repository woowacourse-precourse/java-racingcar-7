package racingcar.model;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceManager {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RaceManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        prepareRace();
        startRace();
        showWinner();
    }

    private void prepareRace() {
        Cars cars = Cars.from(inputView.inputCarNames());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());
        race = new Race(cars, tryCount);
    }

    private void startRace() {
        outputView.printRoundHeader();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.round();
            outputView.printRoundResult(race.getPlayers());
        }
    }

    private void showWinner() {
        Winners winners = race.createWinner();
        outputView.printWinner(winners.getWinner());
    }
}
