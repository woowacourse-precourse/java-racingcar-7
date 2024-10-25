package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.inputCarNames());
        ResultView resultView = new ResultView(cars);
        resultView.moveCarResultView(InputView.inputTryCount());
        resultView.winnerResultView();
    }
}
