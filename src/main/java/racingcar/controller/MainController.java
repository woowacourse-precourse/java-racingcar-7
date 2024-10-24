package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.model.race.Race;
import racingcar.service.RaceService;
import racingcar.view.io.InputManager;

public class MainController {

    private final RaceService raceService;

    public MainController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        List<String> carNames = InputManager.enterCarNames();
        String lapCount = InputManager.enterLapCount();
        Cars registeredCars = raceService.registerCars(carNames, lapCount);

        Race race = Race.of(Lap.of(lapCount));
        DashBoard dashBoard = raceService.startRace(race, registeredCars);
        System.out.println(dashBoard.offerWinners());
    }
}
