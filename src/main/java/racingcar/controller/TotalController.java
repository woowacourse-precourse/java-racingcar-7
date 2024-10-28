package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.race.RaceStarterService;

public class TotalController {
    private static TotalController instance = new TotalController();
    private RaceStarterService raceStarterService;

    private TotalController() {
        raceStarterService = new RaceStarterService();
    }

    private void getInput() {
        InputController.getInputs();
    }

    private void connectRelayServer(Race race) {
        ScreenController.getInstance().connect(race);
    }

    public static TotalController getInstance() {
        if (instance == null) {
            instance = new TotalController();
        }
        return instance;
    }
}
