package racingcar.controller;

import racingcar.service.race.RaceStarterService;

public class TotalController {
    private static TotalController instance = new TotalController();

    private TotalController() {
    }

    private void getInput() {
        InputController.getInputs();
    }

    public static TotalController getInstance() {
        if (instance == null) {
            instance = new TotalController();
        }
        return instance;
    }
}
