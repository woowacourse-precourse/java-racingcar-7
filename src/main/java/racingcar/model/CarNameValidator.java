package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    public void validateCarNameList(List<String> carNameList) {
        validateCarListEmpty(carNameList);
        validateCarNameDuplicated(carNameList);

        for (String carName : carNameList) {
            validateCarNameLength(carName);
            validateCarNameEmpty(carName);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름이 공백일 수 없습니다.");
        }
    }

    private void validateCarListEmpty(List<String> carNameList) {
        if (carNameList.size() == 1 && carNameList.getFirst().isEmpty()) {
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
