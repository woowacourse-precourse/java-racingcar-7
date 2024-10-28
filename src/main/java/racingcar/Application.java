package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int limit = inputView.getRoundLimit();

        RacingGame racingGame = new RacingGame(limit);
        racingGame.setParticipants(carNames);
        racingGame.playGame();
    }
}
