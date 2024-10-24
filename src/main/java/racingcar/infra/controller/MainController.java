package racingcar.infra.controller;

import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.model.race.Race;
import racingcar.service.RaceService;

public class MainController {

    private final RaceService raceService;

    public MainController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        String input = "messi,ji-sung-park,owen";
        String count = "5";
        Cars cars = raceService.generateCars(input, count);
        Race race = Race.of(Lap.of(count));
        DashBoard dashBoard = raceService.startRace(race, cars);
        System.out.println(dashBoard.offerWinners());
    }
}
