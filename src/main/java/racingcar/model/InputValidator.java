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
}
