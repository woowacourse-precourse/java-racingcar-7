package racingcar.service;

import racingcar.model.car.Cars;
import racingcar.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameService {

    public static void play() {
        Cars cars = new Cars(InputView.inputCarNames());
        cars.repeatMove(InputView.inputTryCount(), new MoveStrategy());
        ResultView resultView = new ResultView(cars);
        resultView.moveCarResultView();
    }

}
