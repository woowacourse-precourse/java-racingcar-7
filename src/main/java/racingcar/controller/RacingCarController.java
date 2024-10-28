package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.RandomGenerator;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

import java.util.List;
import java.util.stream.IntStream;


public class RacingCarController {

    ValidateService validateService;
    RacingCarService racingCarService;
    RandomGenerator randomGenerator;

    public RacingCarController(ValidateService validateService, RacingCarService racingCarService, RandomGenerator randomGenerator) {
        this.validateService = validateService;
        this.racingCarService = racingCarService;
        this.randomGenerator = randomGenerator;
    }

    public List<RacingCar> setupRacingCars(List<String> validateNames) {
        return racingCarService.setupRaceCars(validateNames, randomGenerator);
    }

    public List<String> validateName(String names) {
        return validateService.validateName(names);
    }

    public long validateRaceCount(String raceCount) {
        return validateService.validateRaceCount(raceCount);
    }

    public void runRaceRound(List<RacingCar> raceCars) {
        racingCarService.runRound(raceCars);
    }

    public List<RacingCar> findBestDriver(List<RacingCar> raceCars) {
        return racingCarService.findBestDriver(raceCars);
    }

}
