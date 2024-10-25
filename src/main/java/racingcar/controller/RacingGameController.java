package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    private final CarFactory carFactory = new CarFactory();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
        String carNames = racingGameInputView.getCarNames();
        List<Car> cars = carFactory.createCars(carNames);
    }
}
