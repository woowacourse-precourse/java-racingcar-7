package racingcar.controller;

import racingcar.model.Cars;

public class Controller {
    private final Cars cars = new Cars();
    private final InputController inputController = new InputController();
    private final RacingController racingController = new RacingController();
    public Controller(){

    }

    public void gameStart(){
        inputController.validateInputFormat();
        inputController.validateNameLength();
        inputController.validateNonEmptyNames();
        inputController.addCarsFromInput(cars);

        racingController.playGame(cars);
        racingController.determineAndDisplayWinners(cars);
    }

}
