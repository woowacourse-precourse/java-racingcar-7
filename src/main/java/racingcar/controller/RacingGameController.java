package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceRound;
import racingcar.view.InputView;

public class RacingGameController {
    private Cars cars = new Cars();


    public void startGame(){
        cars.addCarFromString(InputView.getCarNames());
        RaceRound rounds = new RaceRound(InputView.getNumberOfRounds());
    }
}
