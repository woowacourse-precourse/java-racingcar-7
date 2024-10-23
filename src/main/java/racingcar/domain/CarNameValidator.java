package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class CarNameValidator {
    public void validate(List<String> carNames) {
        validateLengthCarName(carNames);
        validateDuplicationCarName(carNames);
    }

    private void validateLengthCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 빈칸이 아니어야 합니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
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
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
