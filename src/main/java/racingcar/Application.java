package racingcar;

import racingcar.game.RacingGame;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class Application {
    public static void main(String[] args) {
        RacingInputView inputView = new RacingInputView();
        RacingOutputView outputView = new RacingOutputView();
        RacingGame game = new RacingGame(inputView, outputView);

        game.play();
    }
}
