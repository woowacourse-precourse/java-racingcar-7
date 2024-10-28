package racingcar.service.race;

import racingcar.domain.Race;
import racingcar.service.racer.RacerService;

public class LapUpdateService {

    private final RacerService racerService;
    private final Race race;

    public LapUpdateService(Race race) {
        this.racerService = new RacerService();
        this.race = race;
    }

    private void updateEntry() {
        race.getEntry().forEach(racerService::pushOrHold);
    }
}
