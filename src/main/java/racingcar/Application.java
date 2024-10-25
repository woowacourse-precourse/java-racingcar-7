package racingcar;

import racingcar.racing.controller.RacingGameController;
import racingcar.racing.model.RacingGameConcreteFactory;
import racingcar.racing.view.InputView;
import racingcar.racing.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameConcreteFactory racingGameFactory = new RacingGameConcreteFactory();

        RacingGameController racingGameController = new RacingGameController(inputView,
                outputView, racingGameFactory);
    }
}
