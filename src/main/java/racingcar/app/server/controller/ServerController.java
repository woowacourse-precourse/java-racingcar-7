package racingcar.app.server.controller;

import java.util.List;
import racingcar.app.middleware.dto.InputDTO;
import racingcar.app.middleware.dto.OutputDTO;
import racingcar.app.server.model.car.Cars;
import racingcar.app.server.model.dashboard.DashBoard;
import racingcar.app.server.model.race.Lap;
import racingcar.app.server.service.RaceService;
import racingcar.app.server.view.DashBoardView;

public class ServerController {

    private final RaceService raceService;

    public ServerController(final RaceService raceService) {
        this.raceService = raceService;
    }

    public OutputDTO run(final InputDTO inputs) {
        List<String> carNames = inputs.carNames();
        long lapCount = inputs.lapCount();

        Cars participatingCars = raceService.registerCars(lapCount, carNames);
        DashBoard dashBoard = raceService.startRace(Lap.from(lapCount), participatingCars);
        DashBoardView dashBoardView = DashBoardView.from(dashBoard);
        return OutputDTO.from(dashBoardView);
    }
}
