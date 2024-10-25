package racingcar.model;

import java.util.regex.Pattern;
import racingcar.error.InputErrorType;
import racingcar.error.InputException;

public class InputValidator {
    public void validateCarName(String carName) {
        validateFiveCharactersOrLess(carName);
        validateLowerCaseEnglishOrKorean(carName);
    }

    private void validateLowerCaseEnglishOrKorean(String carName) {
        if (!Pattern.matches("^[가-힣a-z]{1,5}$", carName)) {
            throw new InputException(InputErrorType.INVALID_CAR_NAME_FORMAT);
        }
    }

    private void validateFiveCharactersOrLess(String carName) {
        if (carName.length() > 5) {
            throw new InputException(InputErrorType.INVALID_CAR_NAME_LENGTH);
        }
    }

    public void validateTrialCount(String trialCount) {
        validateParseToInteger(trialCount);
        validateGreaterThanZero(trialCount);
    }

    private void validateParseToInteger(String trialCount) {
        try {
            Integer.parseInt(trialCount);
        } catch (NumberFormatException exception) {
            throw new InputException(InputErrorType.INVALID_TRIAL_COUNT_TYPE);
        }
    }

    private void validateGreaterThanZero(String trialCount) {
        int parsedInt = Integer.parseInt(trialCount);

        if (parsedInt <= 0) {
            throw new InputException(InputErrorType.INVALID_TRIAL_COUNT_RANGE);
        }
    }
}
