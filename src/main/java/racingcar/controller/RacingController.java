package racingcar.controller;

import racingcar.view.InputReader;

public class RacingController {

    private final InputReader inputReader;

    public RacingController(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void startRace() {
        String racingCars = inputReader.inputRacingCarNames();
    }
}
