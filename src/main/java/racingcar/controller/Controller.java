package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;

public class Controller {
    private InputView inputView = new InputView();
    private Game game=new Game();

    private void runningGame() {
        String racingCarNames = inputView.InputCarNames();
        Integer trialCount = inputView.InputTrialCount();
        Cars cars = new Cars(racingCarNames);
        game.nRoundGame(cars, trialCount);
    }
}
