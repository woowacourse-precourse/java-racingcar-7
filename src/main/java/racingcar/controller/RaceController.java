package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.RaceService;

public class RaceController {
    private final RaceService raceService;

    public RaceController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public Race registerRace(final List<Car> carList, final int attemptCount) {
        return raceService.registerRace(carList, attemptCount);
    }

    public void playRound(final Race race) {
        raceService.playRound(race);
    }

    public List<Car> getWinnerCarList(final Race race) {
        List<Car> carList = race.getCarList();
        int maxDistance = getMaxDistance(race);

        return raceService.getCarListWithMaxDistance(carList, maxDistance);
    }

    private int getMaxDistance(final Race race) {
        List<Integer> distanceList = race.getDistanceList();
        return raceService.getMaxDistance(distanceList);
    }
}
