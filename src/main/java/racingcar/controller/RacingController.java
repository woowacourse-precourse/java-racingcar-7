package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputReader;
import racingcar.view.OutputWriter;

import java.util.Map;

public class RacingController {

    private final InputReader inputReader;
    private final Racing racing;
    private final OutputWriter outputWriter;

    public RacingController(InputReader inputReader, Racing racing, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.racing = racing;
        this.outputWriter = outputWriter;
    }

    public void startRace() {
        String racingCarNames = inputReader.inputRacingCarNames();
        int racingCount = inputReader.inputRacingCount();

        Map<String, Integer> racingCars = racing.splitCarNamesByComma(racingCarNames);

        outputWriter.printRaceResultsMessage();
        racing.executeRace(racingCars, racingCount);

    }
}
