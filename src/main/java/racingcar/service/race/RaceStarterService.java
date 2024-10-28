package racingcar.service.race;

import racingcar.domain.Race;
import racingcar.domain.Registration;
import racingcar.service.prep.RacePrepService;

public class RaceStarterService {

    private final RacePrepService racePrepService;
    private Race race;

    public RaceStarterService() {
        this.racePrepService = new RacePrepService();
    }

    public void openRace(Registration registration) {
        race = racePrepService.prepare(registration);
    }

    public Race getRace() {
        return race;
    }
}
