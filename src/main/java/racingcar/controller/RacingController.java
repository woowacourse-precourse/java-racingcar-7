package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.service.input.RegistrationService;
import racingcar.service.prep.RacePrepService;
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

    public void gameUpdate() {
        lapUpdateService.runLap();
    }
}
