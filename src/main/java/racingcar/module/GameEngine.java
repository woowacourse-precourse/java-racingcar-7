package racingcar.operator;

import racingcar.user.UserObject;

public class GameEngine {
    public int randomNum;

    public void extractRandom() {
        randomNum = RandomNumberGenerator.generateRandomNumber();
    }

    public void scoreUpdate(UserObject user) {
        if (checkScoreEligibility()) {
            user.updateUserScore();
        }
    }

    private boolean checkScoreEligibility() {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
