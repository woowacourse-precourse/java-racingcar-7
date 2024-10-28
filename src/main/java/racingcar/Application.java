package racingcar;

import racingcar.controller.RacingController;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.service.RaceService;
import racingcar.service.ThresholdScoreRaceService;

public class Application {
    public static void main(String[] args) {
        final NumberGenerator numberGenerator = getNumberGenerator();
        final RaceService raceService = getRaceService(numberGenerator);
        final RacingController racingController = new RacingController(raceService);
        racingController.run();
    }

    private static RaceService getRaceService(final NumberGenerator numberGenerator) {
        return new ThresholdScoreRaceService(numberGenerator);
    }

    private static NumberGenerator getNumberGenerator() {
        return RandomNumberGenerator.getInstance();
    }
}
