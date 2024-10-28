package racingcar.controller;

import racingcar.domain.RacingCars;

import java.util.List;
import java.util.stream.IntStream;

public class MainController {

    private final RacingCarInputController racingCarInputController;
    private final RacingCarController racingCarController;
    private final RacingCarOutputController racingCarOutputController;

    public MainController(RacingCarInputController racingCarInputController, RacingCarController racingCarController, RacingCarOutputController racingCarOutputController) {
        this.racingCarInputController = racingCarInputController;
        this.racingCarController = racingCarController;
        this.racingCarOutputController = racingCarOutputController;
    }

    public void run() {
        List<String> validatedNames = getValidatedNames();
        long validatedRaceCount = getValidatedRaceCount();
        RacingCars racingCars = setupRacingCars(validatedNames);
        runRaceRounds(validatedRaceCount, racingCars);
        printRaceResults(racingCars);
    }

    private List<String> getValidatedNames() {
        String names = racingCarInputController.getRacingCarNames();
        return racingCarController.validateName(names);
    }

    private long getValidatedRaceCount() {
        String raceCount = racingCarInputController.getRacingCarRaceCount();
        return racingCarController.validateRaceCount(raceCount);
    }

    private RacingCars setupRacingCars(List<String> validatedNames) {
        return racingCarController.setupRacingCars(validatedNames);
    }

    private void runRaceRounds(long validatedRaceCount, RacingCars racingCars) {
        racingCarOutputController.startRaceRound();
        IntStream.range(0, (int) validatedRaceCount)
                .forEach(i -> {
                    racingCarController.runRaceRound(racingCars);
                    racingCarOutputController.showRaceRound(racingCars);
                });
    }

    private void printRaceResults(RacingCars racingCars) {
        RacingCars bestDrivers = racingCarController.findBestDriver(racingCars);
        racingCarOutputController.printResult(bestDrivers);
    }


}
