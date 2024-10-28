package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    String regex = "[\\p{Cntrl}!@#$%^&*()\\-+=\\{\\}\\[\\]|:;\"'<>?,/\\\\`~]+";

    public void validateCarNameList(List<String> carNameList) {
        validateCarListEmpty(carNameList);

        for (String carName : carNameList) {
            validateCarNameLength(carName);
            validateCarNameEmpty(carName);
            validateNoSpecialChar(carName);
        }

        validateCarNameDuplicated(carNameList);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름이 공백일 수 없습니다.");
        }
    }

    private void validateNoSpecialChar(String carName) {
        if (carName.matches(".*" + regex + ".*")) {
            throw new IllegalArgumentException("자동차 이름은 제어문자 및 메타문자를 포함할 수 없습니다.");
        }
    }

    private void validateCarListEmpty(List<String> carNameList) {
        if (carNameList.isEmpty() || carNameList.size() == 1 && carNameList.getFirst().trim().isEmpty()) {
            throw new IllegalArgumentException("최소 한 대 이상의 자동차가 필요합니다.");
        }
    }

    private void validateCarNameDuplicated(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() < carNameList.size()) {
            throw new IllegalArgumentException("자동차의 이름은 서로 중복될 수 없습니다.");
        }
    }
}
