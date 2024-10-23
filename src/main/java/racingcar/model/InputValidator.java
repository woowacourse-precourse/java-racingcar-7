package racingcar.model;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    public void validateCarNameList(List<String> carNameList) {
        validateUnderFiveLength(carNameList);
        validateLowerCaseOrKorean(carNameList);
    }

    private void validateLowerCaseOrKorean(List<String> carNameList) {
        carNameList.forEach(name -> {
            if (!Pattern.matches("^[가-힣a-z]{1,5}$", name)) {
                throw new IllegalArgumentException("한글과 영어 소문자로 작성해주세요.");
            }
        });
    }

    private void validateUnderFiveLength(List<String> carNameList) {
        carNameList.forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름을 작성해주세요.");
            }
        });
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
