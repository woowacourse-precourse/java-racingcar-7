package racingcar.view;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class Validation {

    public void isNameValid(String playerName) {
        if (playerName.length() >= Constant.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE1);
        }
    }
}
