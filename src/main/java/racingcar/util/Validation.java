package racingcar.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class Validation {
    public void isNameLengthValid(String playerName) {
        if (playerName.length() > Constant.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_LENGTH);
        }
    }

    public void isPlayerCountValid(int playerCount) {
        if (playerCount < Constant.MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MIN_CAR_COUNT);
        }
    }

    public void isPlayerNameDuplicated(ArrayList<String> nameList) {
        for (String name : nameList) {
            int frequency = Collections.frequency(nameList, name);
            if (frequency > 1) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_DUPLICATED);
            }
        }
    }

    public void isPlayerInputBlank(String inputStr) {
        if (inputStr.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAYER_BLANK);
        }
    }

    public void isPlayerInputNull(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PLAYER_NULL);
        }
    }

    public void isPlayerInputDelimiterWrong(String inputStr) {
        if (!inputStr.contains(Constant.INPUT_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DELIMITER);
        }
    }

    public void isTrialInputValid(String inputStr) {
        if (inputStr.matches(Constant.TRIAL_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR_TRIAL_NUM);
    }

    public void isTrialInputNegative(String inputStr) {
        if (Integer.parseInt(inputStr) > 0) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR_TRIAL_SIGN);
    }

    public void isTrialInputDouble(String inputStr) {
        if (inputStr.contains(Constant.DOUBLE_DOT)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_TRIAL_TYPE);
        }
    }
}
