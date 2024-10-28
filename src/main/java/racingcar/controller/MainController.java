package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomsWrapper;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

import java.util.List;
import java.util.stream.IntStream;

public class MainController {

    private final RacingCarInputController racingCarInputController;
    private final RacingCarController racingCarController;
    private final RacingCarOutputController racingCarOutputController;
    private RacingCars racingCars;

    public MainController(RacingCarInputController racingCarInputController, RacingCarController racingCarController, RacingCarOutputController racingCarOutputController) {
        this.racingCarInputController = racingCarInputController;
        this.racingCarController = racingCarController;
        this.racingCarOutputController = racingCarOutputController;
    }

    public void run() {
        List<String> validatedNames = getValidatedNames();
        long validatedRaceCount = getValidatedRaceCount();
        setupRacingCars(validatedNames);
        runRaceRounds(validatedRaceCount);
        printRaceResults();
    }

    private List<String> getValidatedNames() {
        String names = racingCarInputController.getRacingCarNames();
        return racingCarController.validateName(names);
    }

    private long getValidatedRaceCount() {
        String raceCount = racingCarInputController.getRacingCarRaceCount();
        return racingCarController.validateRaceCount(raceCount);
    }

    private void setupRacingCars(List<String> validatedNames) {
        this.racingCars = racingCarController.setupRacingCars(validatedNames);
    }

    private void runRaceRounds(long validatedRaceCount) {
        racingCarOutputController.startRaceRound();
        IntStream.range(0, (int) validatedRaceCount)
                .forEach(i -> {
                    racingCarController.runRaceRound(racingCars);
                    racingCarOutputController.showRaceRound(racingCars);
                });
    }

    private void printRaceResults() {
        RacingCars bestDrivers = racingCarController.findBestDriver(racingCars);
        racingCarOutputController.printResult(bestDrivers);
    }


}
