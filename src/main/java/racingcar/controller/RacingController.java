package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputReader;

public class RacingController {

    private final InputReader inputReader;
    private final Racing racing;

    public RacingController(InputReader inputReader, Racing racing) {
        this.inputReader = inputReader;
        this.racing = racing;
    }

    public void startRace() {
        String racingCars = inputReader.inputRacingCarNames();
        int racingCount = inputReader.inputRacingCount();
    }
}
