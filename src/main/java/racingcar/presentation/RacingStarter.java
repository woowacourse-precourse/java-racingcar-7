package racingcar.presentation;

import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.util.InputParser;

import java.util.List;

public class RacingStarter {
    public static void startRace() {
        makeService().startRace();
    }

    private static RacingService makeService() {
        final List<RacingCar> racers = InputParser.collectRacingCarAsList();
        final int laps = InputParser.takeGameLapsFromUser();
        return new RacingService(racers, laps);
    }
}
