package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        GameController controller = new GameController(inputView, resultView);
        controller.run();
    }
}
