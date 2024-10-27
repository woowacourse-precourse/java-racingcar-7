package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Race race;
    private int tryCount;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        initializeGame();
        playGame();
    }

    private void initializeGame() {
        List<String> carNames = inputView.getCarNames();
        this.tryCount = inputView.getTryCount();
        this.race = new Race(carNames);
    }

    private void playGame() {
        for (int i = 0; i < tryCount; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        race.startRace(1);
        outputView.printRaceStatus(race.getCars());
    }
}
