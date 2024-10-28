package racingcar.controller;

import racingcar.service.race.LapUpdateService;
import racingcar.service.race.RaceStarterService;

public class RacingController {
    private static RacingController instance;

    private LapUpdateService lapUpdateService;

    private RacingController() {
    }

    public static RacingController getInstance() {
        if (instance == null) {
            instance = new RacingController();
        }
        return instance;
    }

    public void carMovementSetting(RaceStarterService raceStarterService) {
        lapUpdateService = new LapUpdateService(raceStarterService.getRace());
    }
}
