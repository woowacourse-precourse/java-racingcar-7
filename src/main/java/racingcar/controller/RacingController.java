package racingcar.controller;

import racingcar.model.CarFactory;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        OutputView.printInputCarName();
        String carNames = InputView.inputCarName();
        Cars cars = new Cars(CarFactory.createCars(carNames));
    }

}
