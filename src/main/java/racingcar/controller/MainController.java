package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.service.RaceService;
import racingcar.view.DashBoardView;
import racingcar.view.io.read.InputManager;
import racingcar.view.io.write.OutputManager;

public class MainController {

    private final RaceService raceService;

    public MainController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        InputManager inputManager = InputManager.getInstance();
        List<String> carNames = inputManager.enterCarNames();
        long lapCount = inputManager.enterLapCount();

        Cars participatingCars = raceService.registerCars(lapCount, carNames);
        DashBoard dashBoard = raceService.startRace(Lap.from(lapCount), participatingCars);
        DashBoardView raceResult = DashBoardView.from(dashBoard);

        OutputManager outputManager = OutputManager.getInstance();
        outputManager.showLapCharts(raceResult);
        outputManager.showWinners(raceResult);
    }
}
