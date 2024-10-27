package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
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
