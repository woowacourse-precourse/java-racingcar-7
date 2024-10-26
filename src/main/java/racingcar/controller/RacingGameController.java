package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.RacingGameRound;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    private final CarFactory carFactory = new CarFactory();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
        String carNames = racingGameInputView.getUserInput();
        List<Car> cars = carFactory.createCars(carNames);

        racingGameOutputView.printRacingGameRoundInputMessage();
        RacingGameRound gameRound = new RacingGameRound(racingGameInputView.getUserInput());
    }
}
