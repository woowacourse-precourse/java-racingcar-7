package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.service.RaceService;
import racingcar.view.io.read.InputManager;
import racingcar.view.io.write.OutputManager;

public class MainController {

    private final RaceService raceService;

    public MainController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        List<String> carNames = InputManager.enterCarNames();
        String lapCount = InputManager.enterLapCount();

        Cars registeredCars = raceService.registerCars(lapCount, carNames);
        DashBoard dashBoard = raceService.startRace(Lap.from(lapCount), registeredCars);

        OutputManager.showWinners(dashBoard.rankWinners());
    }
}
