package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingRound;
import racingcar.service.RacingService;
import racingcar.service.RandomNumbersGenerator;
import racingcar.service.ValidatorService;

public class DependencyConfig {

    public RacingController racingController() {
        return new RacingController(racingService(), validatorService());
    }

    private ValidatorService validatorService() {
        return new ValidatorService();
    }

    private RacingService racingService() {
        return new RacingService(racingRound());
    }

    private RacingRound racingRound() {
        return new RacingRound(randomNumberGenerator());
    }

    private RandomNumbersGenerator randomNumberGenerator() {
        return new RandomNumbersGenerator();
    }
}
