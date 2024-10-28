package racingcar.controller;

import racingcar.model.InputProcessor;
import racingcar.model.Race;
import racingcar.model.RaceProcess;
import racingcar.view.InputView;

public class RacingGame {

    public RacingGame() {
    }

    public void start() {
        String carNames = ViewController.readCarNames();
        String moveCount = ViewController.readTryCount();

        InputProcessor inputProcessor = new InputProcessor(carNames, moveCount);

        Race race = new Race(inputProcessor.getCarNames());
        RaceProcess carRacer = new RaceProcess(race);
        carRacer.startRace(inputProcessor.getTryCount());

        ViewController.printWinners(race.getWinners());

        InputView.closeRead();
    }
}
