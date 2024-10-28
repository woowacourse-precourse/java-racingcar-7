package racingcar.module;

import racingcar.user.UserObject;

public class GameEngine {
    public int randomNum;

    public void extractRandom() {
        randomNum = RandomNumberGenerator.generateRandomNumber();
    }

    public void scoreUpdate(UserObject user) {
        if (randomNum >= 4) {
            user.updateUserScore();
        }
    }
}
