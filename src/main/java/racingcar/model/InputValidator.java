package racingcar.model;

import java.util.regex.Pattern;

public class InputValidator {
    public void validateCarName(String carName) {
        validateUnderFiveLength(carName);
        validateLowerCaseOrKorean(carName);
    }

    private void validateLowerCaseOrKorean(String carName) {
        if (!Pattern.matches("^[가-힣a-z]{1,5}$", carName)) {
            throw new IllegalArgumentException("한글과 영어 소문자로 작성해주세요.");
        }
    }

    private void validateUnderFiveLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름을 작성해주세요.");
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
            throw new IllegalArgumentException("정수를 입력해주세요. (1 ~ 2147483647)");
        }
    }

    private void validateGreaterThanZero(String trialCount) {
        int parsedInt = Integer.parseInt(trialCount);

        if (parsedInt <= 0) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해주세요.");
        }
    }
}
