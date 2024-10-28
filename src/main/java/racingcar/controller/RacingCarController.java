package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.validator.RacingCarRepeatCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final RacingCarRepeatCountValidator racingCarRepeatCountValidator;


    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService, RacingCarRepeatCountValidator racingCarRepeatCountValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.racingCarRepeatCountValidator = racingCarRepeatCountValidator;
    }

    public void run() {
            createCars();
            int raceCount = getRaceCount();
            performRaces(raceCount);
            printWinners();
        }

    private void createCars() {
        String inputCarsName = inputView.inputCarsName();
        racingCarService.createRacingCars(inputCarsName);
    }

    private int getRaceCount() {
        String inputCarRacingRepeatCount = inputView.inputCarRacingRepeatCount();
        racingCarRepeatCountValidator.validateRepeatCountNumberFormat(inputCarRacingRepeatCount);
        return Integer.parseInt(inputCarRacingRepeatCount);
    }

    private void performRaces(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            racingCarService.advanceRacingCars();
            List<String[]> results = racingCarService.getCarNamesAndAdvanceResults();
            printRaceResults(results);
            outputView.printLineSpace();
        }
    }

    private void printRaceResults(List<String[]> results) {
        for (String[] result : results) {
            outputView.printCarRacingResult(result[0], result[1]);
        }
    }

    private void printWinners() {
        String winners = racingCarService.selectCarRacingWinners();
        outputView.printCarRacingWinner(winners);
    }

}
