package racingcar.controller;

import static racingcar.view.io.read.InputManager.enterCarNames;
import static racingcar.view.io.read.InputManager.enterLapCount;
import static racingcar.view.io.write.OutputManager.showLapCharts;
import static racingcar.view.io.write.OutputManager.showWinners;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.service.RaceService;
import racingcar.view.DashBoardView;

public class MainController {

    private final RaceService raceService;

    public MainController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        List<String> carNames = enterCarNames();
        String lapCount = enterLapCount();

        Cars participatingCars = raceService.registerCars(lapCount, carNames);
        DashBoard dashBoard = raceService.startRace(Lap.from(lapCount), participatingCars);

        DashBoardView raceResult = DashBoardView.from(dashBoard);
        showLapCharts(raceResult);
        showWinners(raceResult);
    }
}
