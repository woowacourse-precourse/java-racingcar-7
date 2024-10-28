package racingcar;

import racingcar.controller.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.showInputView();

        Game game = new Game(inputView.getCarNames(), inputView.getCount());
        List<String> winners = game.run();

        OutputView.showOutputView(winners);
    }
}
