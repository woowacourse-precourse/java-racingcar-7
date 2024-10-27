package racingcar.domain.racingcar.presentation;

import racingcar.domain.racingcar.service.RaceService;
import racingcar.domain.racingcar.domain.Race;
import java.util.List;

public class RaceController {

    private static RaceController instance;
    private final RaceService raceService;

    private RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public static RaceController getInstance(RaceService raceService) {
        if (instance == null) {
            instance = new RaceController(raceService);
        }
        return instance;
    }

    public Race createRace(List<String> carNames, int rounds) {
        return raceService.createRace(carNames, rounds);
    }

    public void moveAllCars(Race race) {
        raceService.moveAllCars(race);
    }

    public boolean isRaceFinished(Race race) {
        return race.isRaceFinished();
    }

    public List<String> getWinners(Race race) {
        return raceService.getWinnerNames(race);
    }

    public List<String> getRaceStatus(Race race) {
        return raceService.getRaceStatus(race);
    }
}