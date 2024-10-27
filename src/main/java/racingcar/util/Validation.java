package racingcar.util;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class Validation {

    public void isNameLengthValid(String playerName) {
        if (playerName.length() >= Constant.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE1);
        }
    }

    public void isPlayerCountValid(int playerCount) {
        if (playerCount < Constant.MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE2);
        }
    }

    public void isPlayerInputBlank(String inputStr) {
        if (inputStr.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE3);
        }
    }

    public void isPlayerInputNull(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE4);
        }
    }

    public void isPlayerInputDelimiterWrong(String inputStr) {
        if (!inputStr.contains(Constant.INPUT_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE5);
        }
    }

    public void isTrialInputValid(String inputStr) {
        if (inputStr.matches(Constant.TRIAL_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE6);
    }

    public void isTrialInputNegative(String inputStr) {
        if (Integer.parseInt(inputStr) > 0) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE7);
    }

    public void isTrialInputDouble(String inputStr) {
        if (inputStr.contains(Constant.DOUBLE_DOT)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE8);
        }
    }
}
