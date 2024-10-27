package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidation {

    public void isValidDuplicate(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() < carNameList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public void isValidEmpty(List<String> carNameList) {
        for (String name : carNameList) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
            }
        }
    }

    public void isValidLength(List<String> carNameList) {
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
            }
        }
    }

    // 모든 유효성 검사를 한번에 수행하는 메서드
    public void validateCarNames(List<String> carNameList) {
        isValidDuplicate(carNameList);
        isValidEmpty(carNameList);
        isValidLength(carNameList);
    }
}
