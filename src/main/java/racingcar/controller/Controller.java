package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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
        List<Car> carGroup = game.findWinningCars(cars);

    }
}
