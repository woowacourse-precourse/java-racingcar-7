package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String carNames = inputView.getCarNames();
        String rounds = inputView.getRounds();

        Game game = new Game(carNames, rounds);

        outputView.showResult(game);
        outputView.showWinner(game);
    }
}
