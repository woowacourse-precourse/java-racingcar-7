package racingcar.server.controller;

import java.util.List;
import racingcar.client.model.InputManager;
import racingcar.client.model.OutputManager;
import racingcar.server.model.car.Cars;
import racingcar.server.model.dashboard.DashBoard;
import racingcar.server.model.race.Lap;
import racingcar.server.service.RaceService;
import racingcar.server.view.DashBoardView;

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
