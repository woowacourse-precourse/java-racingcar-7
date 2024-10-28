package racingcar.service.race;

import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.service.prep.RacePrepService;

public class RaceStarterService {
    private final RacePrepService racePrepService;
    private final Registration registration;

    public RaceStarterService(RacePrepService racePrepService, Registration registration) {
        this.racePrepService = racePrepService;
        this.registration = registration;
    }

    public Race openRace() {
        return racePrepService.prepare(registration);
    }
}
