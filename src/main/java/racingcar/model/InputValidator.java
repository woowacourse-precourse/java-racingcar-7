package racingcar.model;

import static racingcar.common.Constant.MAX_CAR_NAME_LENGTH;
import static racingcar.common.Constant.MIN_CAR_NAME_LENGTH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.error.InputErrorType;
import racingcar.error.InputException;

public class InputValidator {
    public void validateCarName(String carName) {
        validateFiveCharactersOrLess(carName);
        validateLowerCaseEnglishOrKorean(carName);
    }

    private void validateLowerCaseEnglishOrKorean(String carName) {
        String carNameRegex = String.format("^[가-힣a-z]{%d,%d}$", MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);

        if (!Pattern.matches(carNameRegex, carName)) {
            throw new InputException(InputErrorType.INVALID_CAR_NAME_FORMAT);
        }
    }

    private void validateFiveCharactersOrLess(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
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

    public void validateDuplication(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() != carNameList.size()) {
            throw new InputException(InputErrorType.INVALID_CAR_NAME_DUPLICATION);
        }
    }
}
