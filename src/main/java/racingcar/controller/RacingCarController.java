package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.util.RandomGenerator;

import java.util.List;


public class RacingCarController {

    ValidateService validateService;
    RacingCarService racingCarService;
    RandomGenerator randomGenerator;

    public RacingCarController(ValidateService validateService, RacingCarService racingCarService, RandomGenerator randomGenerator) {
        this.validateService = validateService;
        this.racingCarService = racingCarService;
        this.randomGenerator = randomGenerator;
    }

    public RacingCars setupRacingCars(List<String> validateNames) {
        return racingCarService.setupRaceCars(validateNames, randomGenerator);
    }

    public List<String> validateName(String names) {
        return validateService.validateName(names);
    }

    public long validateRaceCount(String raceCount) {
        return validateService.validateRaceCount(raceCount);
    }

    public void runRaceRound(RacingCars raceCars) {
        racingCarService.runRound(raceCars);
    }

    public RacingCars findBestDriver(RacingCars raceCars) {
        return racingCarService.findBestDriver(raceCars);
    }

}
