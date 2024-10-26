package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputReader;

import java.util.Map;

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

        Map<String, Integer> racingCarNames = racing.splitCarNamesByComma(racingCars);

        racing.executeRace(racingCarNames, racingCount);

    }
}
