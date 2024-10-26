package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Game game=new Game();

    private void runningGame() {
        String racingCarNames = inputView.InputCarNames();
        Integer trialCount = inputView.InputTrialCount();
        Cars cars = new Cars(racingCarNames);
        for(int i=0;i<trialCount;i++){
            game.oneRoundGame(cars);
            outputView.printTrialResult(cars);
        }
    }
}
