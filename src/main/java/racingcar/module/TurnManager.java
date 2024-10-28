package racingcar.module;

import racingcar.controller.GameController;
import racingcar.user.UserObject;
import racingcar.view.InputView;

public class TurnManager {
    private UserObject[] user;
    private int TURN;
    private GameEngine gameEngine = new GameEngine();

    public void progressTurn() {
        for (int i = 0; i < TURN; i++) {
            executeEachTurn();
        }
        endTurn();
    }

    private void executeEachTurn() {
        for (UserObject users : user) {
            gameEngine.extractRandom();
            gameEngine.scoreUpdate(users);
        }
        GameController.displayProgress(user);
    }

    public void endTurn() {
        GameController.displayWinner(new WinnerSelector(user).getTopScores());
    }

    public TurnManager(UserObject[] user) {
        this.user = user;
        this.TURN = InputView.tryNumber;
    }

}
