package racingcar;

import racingcar.controller.RoundController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RoundController racing = new RoundController(inputView, outputView);

        racing.gameStart();
    }
}
