package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
    InputController inputController = new InputController();

    public void run() {
        initCar();
    }

    private void initCar() {
        inputController.initCars();
    }
}
