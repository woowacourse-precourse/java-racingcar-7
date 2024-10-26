package racingcar.server.controller;

import java.util.List;
import racingcar.middleware.dto.InputDTO;
import racingcar.middleware.dto.OutputDTO;
import racingcar.server.model.car.Cars;
import racingcar.server.model.dashboard.DashBoard;
import racingcar.server.model.race.Lap;
import racingcar.server.service.RaceService;
import racingcar.server.view.DashBoardView;

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
