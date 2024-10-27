package racingcar.operator;

import racingcar.controller.GameController;
import racingcar.user.SettingGameUser;
import racingcar.user.UserObject;
import racingcar.view.InputView;

public class GameEngine {
    UserObject[] user;
    public static int NUMBER_OF_USERS = 0;
    public static int TURN_NUMBER = 0;

    public void progressGame() {
        startNewTurn();
        GameController.displayProgress();
    }

    private void startNewTurn() {
        for (UserObject users : user) {
            playUserTurn(users);
        }
        GameController.displayProgress();
    }

    private void playUserTurn(UserObject user) {
        int randomNum = RandomNumberGenerator.generateRandomNumber();
        if (checkScoreEligibility(randomNum)) {
            user.updateUserScore();
        }
    }

    private boolean checkScoreEligibility(int randomNum) {
        if (randomNum >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public GameEngine() {
        this.user = SettingGameUser.user;
        NUMBER_OF_USERS = user.length;
        TURN_NUMBER = InputView.trynum;
    }
}
