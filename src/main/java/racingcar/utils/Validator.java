package racingcar.utils;

import static racingcar.utils.Constant.CAR_NAME_BLANK_ERROR;
import static racingcar.utils.Constant.CAR_NAME_LENGTH_ERROR;
import static racingcar.utils.Constant.GAME_COUNT_FORMAT_ERROR;
import static racingcar.utils.Constant.GAME_COUNT_POSITIVE_ERROR;

import java.util.ArrayList;

public class Validator {
    public void validateInputCarName(ArrayList<String> carNames) {

        for (String car : carNames) {
            validateCarName(car);
        }
    }

    private void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public void validateInputGameCount(String gameCount) {
        if (!isValidNumber(gameCount)) {
            throw new IllegalArgumentException(GAME_COUNT_FORMAT_ERROR);
        }
        if (Integer.parseInt(gameCount) < 0) {
            throw new IllegalArgumentException(GAME_COUNT_POSITIVE_ERROR);
        }
    }

    private boolean isValidNumber(String gameCount) {
        try {
            Integer.parseInt(gameCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
