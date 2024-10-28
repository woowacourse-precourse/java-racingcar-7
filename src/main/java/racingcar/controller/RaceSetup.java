package racingcar.controller;

import racingcar.model.InputProcessor;
import racingcar.model.Race;

public class RaceSetup {

    public Race initializeRace() {
        String carNames = ViewController.readCarNames();
        String tryCount = ViewController.readTryCount();

        InputProcessor inputProcessor = new InputProcessor(carNames, tryCount);

        return new Race(inputProcessor.getCarNames(), inputProcessor.getTryCount());
    }
}