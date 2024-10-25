package racingcar.domain.validator;

import java.util.HashMap;
import java.util.List;

public class CarNameValidator {
    public void validate(List<String> carNames) {
        validateEmptyList(carNames);
        validateLengthCarName(carNames);
        validateDuplicationCarName(carNames);
    }
    private void validateEmptyList(List<String> carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException("입력한 값은 ,만 있으면 안됩니다");
        }
    }
    private void validateLengthCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어있거나 공백이어서는 안됩니다 : " + carName);
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다 : " + carName.length());
            }
        }
    }

    private void validateDuplicationCarName(List<String> carNames) {
        HashMap<String, Integer> carsMap = new HashMap<>();
        for (String carName : carNames) {
            carsMap.put(carName, carsMap.getOrDefault(carName, 0) + 1);
        }
        for (int count : carsMap.values()) {
            if (count > 1) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다 : " + count);
            }
        }
    }
}
